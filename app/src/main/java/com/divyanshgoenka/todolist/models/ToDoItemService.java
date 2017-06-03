package com.divyanshgoenka.todolist.models;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by divyanshgoenka on 03/06/17.
 */

public interface ToDoItemService {
    @GET("/todoitems")
    Observable<List<ToDoItem>> listItems();
}
