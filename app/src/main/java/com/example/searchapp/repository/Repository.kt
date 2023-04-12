package com.example.searchapp.repository

import com.example.searchapp.model.MetadataResponse
import com.example.searchapp.model.SearchResponse
import com.example.searchapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun searchPhotos(query:String,page:Int?=null,perPage:Int?=null): Resource<SearchResponse>
    suspend fun getPhotoMetaData(photoId:String): Resource<MetadataResponse>


}