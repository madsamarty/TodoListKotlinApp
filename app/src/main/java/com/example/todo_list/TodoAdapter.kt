package com.example.todo_list

import android.annotation.SuppressLint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.databinding.ItemTodoBinding



class TodoAdapter (private val todos: MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = ItemTodoBinding.inflate(inflater,parent,false)
        return TodoViewHolder(v)
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean){
        if (isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    fun addtodo(todo: Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteTodos(){
        todos.removeAll {
                todo -> todo.isChecked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currTodo = todos[position]
        holder.itemView.apply {
            holder.binding.tvTodoTitle.text = currTodo.title
            holder.binding.cbDone.isChecked = currTodo.isChecked
            toggleStrikeThrough(holder.binding.tvTodoTitle, currTodo.isChecked)
            holder.binding.cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(holder.binding.tvTodoTitle, isChecked)
                currTodo.isChecked = !currTodo.isChecked
            }

        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}