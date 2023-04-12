package com.example.searchapp.model

import android.support.annotation.Keep

@Keep
data class FlickrPhoto (
        val id: String,
        val title: String,
        val url: String
        )
