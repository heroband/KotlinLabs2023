package com.example.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val data = ArrayList<ItemsViewModel>()

        for(i in 1..12){
            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "штука"+i, R.drawable.ic_launcher_foreground))
        }

        val adapter = CustomAdapter(data){position ->
            Toast.makeText(this,data[position].toString(), Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter

    }
}