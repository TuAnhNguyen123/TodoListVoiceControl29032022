package com.example.todolistvoicecontrol29032022.data.datasource;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todolistvoicecontrol29032022.data.datasource.local.entities.TodoEntity;

@Database(entities = {TodoEntity.class},version = 1)
public abstract class TodoDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "todo_database.sql";
    private static TodoDatabase instance;

    public static synchronized TodoDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TodoDatabase.class,
                    DATABASE_NAME)
                    .build();
        }
        return instance;
    }
    public abstract TodoDAO toDoDAO();
}