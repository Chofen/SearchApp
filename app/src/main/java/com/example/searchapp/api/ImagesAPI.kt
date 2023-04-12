package com.example.searchapp.api


import android.widget.EditText
import com.example.searchapp.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

import com.example.searchapp.util.Constants.API_KEY
import retrofit2.Call

interface ImagesAPI {

    @GET("rest/?method=flickr.photos.search&format=json&nojsoncallback=1")

    fun searchImages(
      //  @Query("api_key") apiKey: String,
        @Query("text") searchText: EditText,
        @Query("page") page: Int): Call<SearchResponse>

}