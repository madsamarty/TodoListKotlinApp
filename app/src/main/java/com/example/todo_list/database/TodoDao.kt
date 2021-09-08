package com.example.todo_list.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao<TodoItemRoom>{

    /*@Query("SELECT*FROM item_data WHERE id=:tid")
    fun getTodoItem(tid: Int)*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTodo(todo: TodoItemRoom)

    @Update
    fun updateTodo(todo: TodoItemRoom)

    @Delete
    fun removeTodo(todo: TodoItemRoom)
}