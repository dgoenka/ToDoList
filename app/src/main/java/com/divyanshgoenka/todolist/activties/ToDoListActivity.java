package com.divyanshgoenka.todolist.activties;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.divyanshgoenka.todolist.R;
import com.divyanshgoenka.todolist.adapter.ToDoListAdapter;
import com.divyanshgoenka.todolist.models.ToDoItem;
import com.divyanshgoenka.todolist.models.ToDoItemsProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ToDoListActivity extends AppCompatActivity {

    private static final int ADD_RESULT = 1;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    LinearLayoutManager linearLayoutManager;
    private Disposable disposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_to_do_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        fab.setOnClickListener(view -> startAddActivity());

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void onResume() {
        super.onResume();
        disposable = Observable.create(new ToDoItemsProvider()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::setData, this::error);
    }

    @Override
    protected void onPause() {
        super.onPause();
        disposable.dispose();
    }

    private void setData(List<ToDoItem> toDoItems) {
        recyclerView.setAdapter(new ToDoListAdapter(this, toDoItems));
    }

    private void error(Throwable throwable) {
    }

    private void startAddActivity() {
        startActivityForResult(new Intent(this, AddEditToDoItemActivity.class), ADD_RESULT);
    }

}
