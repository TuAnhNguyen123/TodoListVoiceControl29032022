package com.example.todolistvoicecontrol29032022.data.repository;

import android.content.Context;

import com.example.todolistvoicecontrol29032022.data.datasource.TodoDAO;
import com.example.todolistvoicecontrol29032022.data.datasource.TodoDatabase;
import com.example.todolistvoicecontrol29032022.data.datasource.local.entities.TodoEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public class TodoRepository {
    private TodoDAO todoDao;

    public TodoRepository(Context context){
        todoDao = TodoDatabase.getInstance(context).toDoDAO();
    }

    public Flowable<List<TodoEntity>> getTodoLists() {
        return todoDao.getTodoLists();
    }

    public Maybe<Long> insertTodo(TodoEntity todoEntity) {
        return todoDao.insertTodo(todoEntity);
    }

    public Maybe<Integer> updateTodo(TodoEntity todoEntity) {
        return todoDao.updateTodo(todoEntity);
    }

    public Completable deleteTodo(TodoEntity todoEntity) {
        return todoDao.deleteTodo(todoEntity);
    }
}
