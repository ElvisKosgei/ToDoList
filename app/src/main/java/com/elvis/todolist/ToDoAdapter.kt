package com.elvis.todolist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val  todos: MutableList<ToDo>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {
    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    private fun toggleStrikeThrough(toDoTitle: TextView, isChecked: Boolean) {

    }

      override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentToDo = todos[position]
        holder.itemView.apply {
            ToDoTitle.text = currentToDo.title
            checkBox.isChecked = currentToDo.isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size

    }
/*
    override fun onBindViewHolder(holder: ToDoAdapter.ToDoViewHolder, position: Int) {
        val currentToDo = todos[position]
        holder.ToDoTitle.text = currentToDo.title
        holder.checkBox.text = currentToDo.isChecked
        holder.itemView.setOnClickListener {
            //Toast.makeText(holder.itemView.context, user.email, Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("name", user.name)
            intent.putExtra("email", user.email)
            intent.putExtra("phone", user.phone)
            intent.putExtra("address", user.address)
            intent.putExtra("age", user.age)
            context.startActivity(intent)
        }
    }*/
}