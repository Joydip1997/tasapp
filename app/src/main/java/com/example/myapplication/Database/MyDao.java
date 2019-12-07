package com.example.myapplication.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void addTask(Task task);

    @Query("SELECT * FROM task_table")
    List<Task> getTask();
}
