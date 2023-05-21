package com.example.lab10

import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName ("userId")
    val userID:Int,

    @SerializedName ("id")
    val ID:Int,

    val title:String,

    @SerializedName ("body")
    val subtitle:String
)
