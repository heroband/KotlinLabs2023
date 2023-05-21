package com.example.lab10

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab10.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root) // setContentView(view)
        showPosts()
        createPost()

        val fileName = "saved_data"
        binding.buttonSave.setOnClickListener{
            val data1:String = binding.textViewUserID.text.toString()
            val data2:String = binding.textViewID.text.toString()
            val data3:String = binding.textViewTitle.text.toString()
            val data4:String = binding.textViewBody.text.toString()

            val data = data1 + "\n" + data2 + "\n" + data3 + "\n" + data4

            val fileOutputStream: FileOutputStream
            try{
                fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            } catch (e:Exception){
                e.printStackTrace()
            }

        }
    }
    private val baseURL = "https://jsonplaceholder.typicode.com/"
    private lateinit var binding: ActivityMainBinding
    var postsList = ArrayList<Posts>()

    fun showPosts(){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPI:RetrofitAPI = retrofit.create(RetrofitAPI::class.java)
        val call:Call<List<Posts>> = retrofitAPI.getAllPosts()

        call.enqueue(object:Callback<List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if(!response.isSuccessful){
                    binding.textViewUserID.text = "error"
                    binding.textViewID.text = "error"
                    binding.textViewTitle.text = "error"
                    binding.textViewBody.text = "error"
                }
                postsList = response.body() as ArrayList<Posts>
                binding.textViewUserID.text = postsList[2].userID.toString()
                binding.textViewID.text = postsList[2].ID.toString()
                binding.textViewTitle.text = postsList[2].title
                binding.textViewBody.text = postsList[2].subtitle
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun createPost() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPI: RetrofitAPI = retrofit.create(RetrofitAPI::class.java)

        val newPost = Posts(userID = 1, ID = 101, title = "New Post", subtitle = "This is a new post.")

        val call: Call<Posts> = retrofitAPI.createPost(newPost)

        call.enqueue(object : Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful) {
                    val createdPost = response.body()
                    // Действия после успешного создания поста
                    Toast.makeText(applicationContext, "Post created successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Failed to create post.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }




}