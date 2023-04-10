package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab6.databinding.ActivitySecondBinding

class second_activity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button2.setOnClickListener{
            val intentUserData = intent.getParcelableExtra<User>("userData")
            val intentAmount = intent.getIntExtra("amount", -1)

            intentUserData.let {
                if(intentAmount!=-1){
                    binding.textView.text = "$it $intentAmount"
                }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lab6", "destroyCall")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("lab6", "saveCall")
        outState.apply{
            putString("userData", binding.textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("lab6", "restoreCall")
        savedInstanceState.run{
            binding.textView.text = getString("userData")
        }
    }

}