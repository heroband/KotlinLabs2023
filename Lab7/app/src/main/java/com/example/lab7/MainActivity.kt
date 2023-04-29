package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.lab7.databinding.FragmentFirstBinding

class MainActivity : AppCompatActivity() {

    lateinit var changeFragmentData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragmentData = findViewById(R.id.button)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.frameField, firstFragment)

        fragmentTransaction.commit()


        val fragments = listOf(FirstFragment(), SecondFragment())
        var currentFragmentIndex = 0
        changeFragmentData.setOnClickListener{
            currentFragmentIndex = (currentFragmentIndex + 1) % fragments.size // Увеличиваем индекс на 1, но если находимся в конце списка, то начинаем сначала
            val nextFragment = fragments[currentFragmentIndex]
            supportFragmentManager.beginTransaction().replace(R.id.frameField, nextFragment).addToBackStack(null).commit()
        }

    }
}