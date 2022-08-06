package com.example.todolistvoicecontrol29032022.data.enums;

import android.graphics.Color;

import androidx.room.TypeConverters;

@TypeConverters
public enum PriorityColorEnum {
    HIGH ("#8d66bd"),
    DEFAULT ("#FFBB86FC");

    private String name;

    PriorityColorEnum(String s) {
        name = s;
    }

    public String getName() {
        return this.name;
    }

}
