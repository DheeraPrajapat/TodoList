package com.example.todolist.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.Classes.TodoItem;
import com.example.todolist.R;
import com.example.todolist.TodoItem_Activity;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder>
{
    Context context;
    ArrayList<TodoItem> arrayList;

    public TodoAdapter(Context context, ArrayList<TodoItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.todo_item,null,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.todoTitle.setText(arrayList.get(position).getTodoTitle());
        holder.todoDescription.setText(arrayList.get(position).getTodoDescription());
        holder.todoCompleted.setText(arrayList.get(position).getCompleted());
        String todoStatus=arrayList.get(position).getCompleted();
        if(todoStatus.equals("yes")){
            holder.todoCompleted.setTextColor(Color.GREEN);
        }else{
            holder.todoCompleted.setTextColor(Color.RED);
        }

        holder.itemView.setOnClickListener(v->{
            Intent intent=new Intent(context, TodoItem_Activity.class);
            intent.putExtra("title",arrayList.get(position).getTodoTitle());
            intent.putExtra("description",arrayList.get(position).getTodoDescription());
            intent.putExtra("completed",arrayList.get(position).getCompleted());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder
    {
        TextView todoTitle,todoDescription,todoCompleted;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            todoTitle=itemView.findViewById(R.id.textView2);
            todoDescription=itemView.findViewById(R.id.textView3);
            todoCompleted=itemView.findViewById(R.id.textView5);
        }
    }
}
