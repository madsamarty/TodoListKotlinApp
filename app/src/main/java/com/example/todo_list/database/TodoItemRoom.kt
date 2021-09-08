package com.example.todo_list.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item_data")
data class TodoItemRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var isChecked : Boolean
) {

}