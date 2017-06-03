package com.divyanshgoenka.todolist.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.IBinder;

import com.divyanshgoenka.todolist.ToDoListApplication;
import com.divyanshgoenka.todolist.models.ToDoItem;
import com.divyanshgoenka.todolist.util.ComponentHelper;
import com.divyanshgoenka.todolist.util.ConnectivityUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ToDoRefreshService extends Service {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private BroadcastReceiver checkAndUnregisterReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (checkAndFetch())
                ToDoRefreshService.this.unregisterReceiver(this);
        }
    };

    public ToDoRefreshService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (!checkAndFetch()) {
            IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(checkAndUnregisterReceiver, intentFilter);
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ComponentHelper.unregisterSafely(this, checkAndUnregisterReceiver);
    }

    public boolean checkAndFetch() {
        if (ConnectivityUtil.isConnected(this)) {
            startFetching();
            return true;
        }
        return false;
    }


    public void startFetching() {
        mCompositeDisposable.add(ToDoListApplication.getInstance().getToDoItemService().listItems()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }


    private void handleResponse(List<ToDoItem> toDoItems) {
        for (ToDoItem toDoItem : toDoItems)
            ToDoListApplication.getInstance().getAppDatabase().toDoItemDao().addEvent(toDoItem);

    }

    private void handleError(Throwable throwable) {

    }
}
