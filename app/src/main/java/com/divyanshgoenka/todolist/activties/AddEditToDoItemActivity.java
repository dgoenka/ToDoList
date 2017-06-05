package com.divyanshgoenka.todolist.activties;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.divyanshgoenka.todolist.R;
import com.divyanshgoenka.todolist.models.ToDoItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by divyanshgoenka on 22/05/17.
 */

public class AddEditToDoItemActivity extends AppCompatActivity {

    public static final String TO_DO_ITEM = "TO_DO_ITEM";


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.title)
    TextInputEditText title;


    @BindView(R.id.description)
    TextInputEditText description;

    @BindView(R.id.when)
    TextInputEditText when;

    ToDoItem toDoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_to_do_item);
        ButterKnife.bind(this);
        toDoItem = (ToDoItem) (savedInstanceState == null ? getIntent().getSerializableExtra(TO_DO_ITEM) : savedInstanceState.getSerializable(TO_DO_ITEM));
        setData(toDoItem);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(TO_DO_ITEM, toDoItem);
    }

    private void setData(ToDoItem toDoItem) {
        if (toDoItem != null) {
            title.setText(toDoItem.title);
            description.setText(toDoItem.detail);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            if (toDoItem != null) {

            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
