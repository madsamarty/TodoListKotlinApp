package com.example.todo_list.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
abstract class PrimDao: TodoDao<TodoItemRoom> {

    @Query("SELECT*FROM item_data ORDER BY id ASC")
    abstract fun getTodoList(): LiveData<List<TodoItemRoom>>


}