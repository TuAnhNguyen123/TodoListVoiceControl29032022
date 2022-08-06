package com.example.todolistvoicecontrol29032022.data.datasource.local.entities;

import androidx.room.TypeConverter;

import com.example.todolistvoicecontrol29032022.data.enums.PriorityColorEnum;

public class PriorityColorConverter {
    @TypeConverter
    public static String fromPriority(PriorityColorEnum priorityColorEnum) {
        return priorityColorEnum.name();
    }

    @TypeConverter
    public static PriorityColorEnum toPriority(String color) {
        return PriorityColorEnum.valueOf(color);
    }
}