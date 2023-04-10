package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.button.setOnClickListener{
            val data = binding.editTextTextPersonName.text.toString().split(" ")
            val userData = User(data[0], data[1].toInt(), data[2].toBooleanStrict())
            startActivity(Intent(this, second_activity::class.java).apply {
                putExtra("userData", userData)
                putExtra("amount", 1)
            })
        }
    }
}