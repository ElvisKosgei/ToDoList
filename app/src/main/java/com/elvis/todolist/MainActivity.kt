package com.elvis.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var toDoAdapter : ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvToDoItems: RecyclerView = findViewById(R.id.rvToDoItems)
        val etToDoTitle: EditText = findViewById(R.id.etToDoTitle)
        val btnAddToDo: Button = findViewById(R.id.btnAddTODo)
        val btnDeleteToDo: Button = findViewById(R.id.btnDeleteTODo)

        toDoAdapter = ToDoAdapter(mutableListOf())

        rvToDoItems.adapter = toDoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val toDoTitle = etToDoTitle.text.toString()
            if (toDoTitle.isNotEmpty()) {
                val toDo = ToDo(etToDoTitle)
                toDoAdapter.addToDo(toDo)
                etToDoTitle.text.clear()
            }
        }

        btnDeleteToDo.setOnClickListener {
            toDoAdapter.deleteDoneToDos()
        }
    }
}
