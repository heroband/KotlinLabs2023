package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.lab5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.editTextTextPersonName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.textView.text = "default"
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.textView.text = "u are changing now"
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.textView.text = "text changed"
            }
        })


        binding.button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.textView.text = binding.editTextTextPersonName.text
            }
        })


        binding.button2.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.textView.text = binding.button2.text
            }
        })

        binding.button3.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.textView.text = binding.button3.text
            }
        })

        binding.button4.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                binding.textView.text = binding.button4.text
                return true
            }
        })

    }
}