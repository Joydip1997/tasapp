package com.example.myapplication.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Task.class},version = 1,exportSchema = false)
public abstract class TaskDatabse extends RoomDatabase {
    public abstract  MyDao myDao();
}
