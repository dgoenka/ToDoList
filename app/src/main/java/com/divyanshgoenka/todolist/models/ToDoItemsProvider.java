package com.divyanshgoenka.todolist.models;

import com.divyanshgoenka.todolist.ToDoListApplication;

import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by divyanshgoenka on 04/06/17.
 */

public class ToDoItemsProvider implements ObservableOnSubscribe<List<ToDoItem>> {

    @Override
    public void subscribe(final ObservableEmitter e) throws Exception {
        List<ToDoItem> list = ToDoListApplication.getInstance().getAppDatabase().toDoItemDao().getAllEvents();
        if (!e.isDisposed())
            e.onNext(list);
    }
}
