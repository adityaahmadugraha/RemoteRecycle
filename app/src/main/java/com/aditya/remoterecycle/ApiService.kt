package com.aditya.remoterecycle

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ApiService {
    @GET("photos")
    fun getPhotos(): Call<List<Photo>>

    @GET("photos")
    fun getPhotos(
        @QueryMap parameter: HashMap<String, String>
    ): Call<List<Photo>>

    @FormUrlEncoded
    @POST("photos")
    fun createPhotos(
    ): Call<List<Photo>>


    @FormUrlEncoded
    @PUT("photos")
    fun putPhotos(
    ): Call<List<Photo>>


    @FormUrlEncoded
    @DELETE("photos/{id}")
    fun deletePhoto(@Path("albumId") id: String): Call<Void>
    abstract fun Photo(): Any

}


