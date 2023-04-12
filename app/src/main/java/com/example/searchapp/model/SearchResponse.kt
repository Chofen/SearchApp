package com.example.searchapp.model

import com.example.searchapp.model.Photo

data class SearchResponse(
    val photo: Photo,
    val stat: String
)