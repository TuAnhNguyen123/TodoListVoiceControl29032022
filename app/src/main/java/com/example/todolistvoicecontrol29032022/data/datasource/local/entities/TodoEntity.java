package com.example.todolistvoicecontrol29032022.data.datasource.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.todolistvoicecontrol29032022.data.enums.PriorityColorEnum;

@Entity(tableName = "to_do")
public class TodoEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String description;

    @ColumnInfo(name = "create_time")
    public long createTime;

    @ColumnInfo(name = "deadline_time")
    public long deadlineTime;

    @ColumnInfo(name = "image_path")
    public String imagePath;

    @ColumnInfo(name = "voice_path")
    public String voicePath;

    @TypeConverters(PriorityColorConverter.class)
    @ColumnInfo(name = "priority_color")
    public PriorityColorEnum priorityColor;

    public TodoEntity() { }

    @Ignore
    public TodoEntity(String title, String description, long createTime, long deadlineTime, String imagePath, String voicePath, PriorityColorEnum priorityColor) {
        this.title = title;
        this.description = description;
        this.createTime = createTime;
        this.deadlineTime = deadlineTime;
        this.imagePath = imagePath;
        this.voicePath = voicePath;
        this.priorityColor = priorityColor;
    }
}