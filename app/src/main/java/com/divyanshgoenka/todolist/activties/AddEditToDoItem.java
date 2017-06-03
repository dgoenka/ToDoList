package com.divyanshgoenka.todolist.activties;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.divyanshgoenka.todolist.R;

/**
 * Created by divyanshgoenka on 22/05/17.
 */

public class AddEditToDoItem extends AppCompatActivity {

    public static final String ACTION = "ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_to_do_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public enum ACTIONS {
        ADD,EDIT
    }
}
