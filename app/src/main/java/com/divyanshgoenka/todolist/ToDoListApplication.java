package com.divyanshgoenka.todolist;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.divyanshgoenka.todolist.database.AppDatabase;
import com.divyanshgoenka.todolist.models.ToDoItem;
import com.divyanshgoenka.todolist.models.ToDoItemService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by divyanshgoenka on 02/06/17.
 */

public class ToDoListApplication extends Application {

    private static final String BASE_URL = "";
    private static final String IS_FIRST_RUN = "IS_FIRST_RUN";
    private static ToDoListApplication instance;

    private AppDatabase appDatabase;


    public ToDoItemService getToDoItemService() {
        return toDoItemService;
    }

    private ToDoItemService toDoItemService;

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "ToDoList-version1").build();
        Retrofit retroFit = new Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        toDoItemService = retroFit.create(ToDoItemService.class);
        firstRun();

    }

    public static ToDoListApplication getInstance() {
        return instance;
    }


    public void firstRun() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //Populating the DB with some sample data
        boolean isFirstRun = sharedPreferences.getBoolean(IS_FIRST_RUN, true);
        if (isFirstRun) {
            sharedPreferences.edit().putBoolean(IS_FIRST_RUN, false).apply();
            appDatabase.toDoItemDao().addEvent(new ToDoItem("Breakfast", "Mexican"));
            appDatabase.toDoItemDao().addEvent(new ToDoItem("Lunch"));
            appDatabase.toDoItemDao().addEvent(new ToDoItem("Dinner", "Mexican"));


        }
    }

}
