package com.example.todolist.Classes;

public class TodoItem
{
    private String todoTitle;
    private String todoDescription;
    private String completed;

    public TodoItem(String todoTitle, String todoDescription, String completed) {
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
        this.completed = completed;
    }

    public TodoItem() {
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
