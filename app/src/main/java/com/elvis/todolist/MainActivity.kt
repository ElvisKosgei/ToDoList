package com.elvis.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var toDoAdapter : ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rvToDoItems: RecyclerView = findViewById(R.id.rvToDoItems)
        var toDoTitle: TextView = findViewById(R.id.toDoTitle)
        var btnAddToDo: Button = findViewById(R.id.btnAddTODo)
        var btnDeleteToDo: Button = findViewById(R.id.btnDeleteTODo)

       // toDoAdapter = ToDoAdapter(mutableListOf())

        rvToDoItems.adapter = toDoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val toDoTitle = toDoTitle.text.toString()
            if (toDoTitle.isNotEmpty()) {
                val toDo = ToDo(toDoTitle)
                toDoAdapter.addToDo(toDo)

            }
        }

        btnDeleteToDo.setOnClickListener {
            toDoAdapter.deleteDoneToDos()
        }
    }
}
