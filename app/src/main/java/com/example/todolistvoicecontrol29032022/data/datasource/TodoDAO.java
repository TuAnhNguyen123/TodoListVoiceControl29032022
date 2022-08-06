package com.example.todolistvoicecontrol29032022.data.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todolistvoicecontrol29032022.data.datasource.local.entities.TodoEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

@Dao
public interface TodoDAO {

    @Query("SELECT * FROM to_do")
    Flowable<List<TodoEntity>> getTodoLists();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Maybe<Long> insertTodo(TodoEntity todoEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    Maybe<Integer> updateTodo(TodoEntity todoEntity);

    @Delete
    Completable deleteTodo(TodoEntity todoEntity);

}
