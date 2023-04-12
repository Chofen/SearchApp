package com.example.searchapp.model

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String

)
