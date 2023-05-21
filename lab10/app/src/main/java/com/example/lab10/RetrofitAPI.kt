package com.example.lab10

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitAPI {

    @GET("/posts")
    fun getAllPosts(): Call<List<Posts>>

    @POST("/posts")
    fun createPost(@Body post: Posts): Call<Posts>

}