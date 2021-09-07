package com.example.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        binding.rvtodoitems.adapter = todoAdapter
        binding.rvtodoitems.layoutManager = LinearLayoutManager(this)

        binding.btnaddtodo.setOnClickListener {
            val todoTitle = binding.ettodotitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addtodo(todo)
                binding.ettodotitle.text.clear()
            }
        }

        binding.btnremovetodo.setOnClickListener {
            todoAdapter.deleteTodos()
        }
    }
}