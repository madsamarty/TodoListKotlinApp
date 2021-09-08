package com.example.todo_list.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [TodoItemRoom::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun getTodoDao(): PrimDao


    companion object{
        private const val databaseName = "TodoDatabase"
        var todoListDatabase : ItemDatabase? = null

        fun getInstance(context: Context): ItemDatabase?{
            if (todoListDatabase == null){
                todoListDatabase = Room.databaseBuilder(context, ItemDatabase::class.java, ItemDatabase.databaseName).allowMainThreadQueries().build()
            }
            return todoListDatabase
        }
    }
}