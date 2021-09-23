package com.example.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.Adapter.TodoAdapter;
import com.example.todolist.Classes.TodoItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TodoAdapter todoAdapter;
    FloatingActionButton addTodo;
    ArrayList<TodoItem> todoItemArrayList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        addTodo.setOnClickListener(v->{
            showAddTodoDialogBox();
        });
    }

    private void showAddTodoDialogBox()
    {
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        View view= LayoutInflater.from(this).inflate(R.layout.add_todo_item,null,false);
        alertDialog.setView(view);
        EditText title=view.findViewById(R.id.editTextTextPersonName);
        EditText description=view.findViewById(R.id.editTextTextMultiLine);
        CheckBox yesCheckbox;
        yesCheckbox=view.findViewById(R.id.checkBox);
        Button addTodo=view.findViewById(R.id.button);
        alertDialog.show();
        addTodo.setOnClickListener(v->{
            String textTitle=title.getText().toString();
            String textDescription=description.getText().toString();
            String cYes="no";
            if(yesCheckbox.isChecked()){
                cYes="yes";
            }
            if(!yesCheckbox.isChecked()){
                cYes="no";
            }

            if(textTitle.equals("") || textDescription.equals("")){
                Toast.makeText(this, "Fill the blank..", Toast.LENGTH_SHORT).show();
            }else {
                addTodoInfo(textTitle,textDescription,cYes);
                alertDialog.dismiss();
            }
        });
        alertDialog.setCancelable(true);
    }

    private void addTodoInfo(String textTitle, String textDescription, String cYes) {
        todoItemArrayList.add(new TodoItem(textTitle,textDescription,cYes));
        todoAdapter.notifyDataSetChanged();
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        addTodo=findViewById(R.id.floatingActionButton);
        todoItemArrayList=new ArrayList<>();
        todoAdapter=new TodoAdapter(this,todoItemArrayList);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(todoAdapter);
    }
}