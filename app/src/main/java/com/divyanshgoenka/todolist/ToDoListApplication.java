package com.divyanshgoenka.todolist;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.divyanshgoenka.todolist.database.AppDatabase;
import com.divyanshgoenka.todolist.models.ToDoItemService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by divyanshgoenka on 02/06/17.
 */

public class ToDoListApplication extends Application {

    private static final String BASE_URL = "";
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
    }

    public static ToDoListApplication getInstance() {
        return instance;
    }


}
