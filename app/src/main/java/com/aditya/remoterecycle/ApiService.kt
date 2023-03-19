package com.aditya.remoterecycle

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap
import java.lang.reflect.Parameter

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
//      @field:("albumId")albumId : String,
//        @field:("title")title : String
    ): Call<List<Photo>>


    @FormUrlEncoded
    @PUT("photos")
    fun putPhotos(
        //   @path("albumId")albumId: String,
//        @field("thumbnailUrl")thumbnailUrl : String,
//        @field("id")id : Int,
//        @field("url")url : String
    ): Call<List<Photo>>


//    @FormUrlEncoded
//    @PATCH("photos")
//    fun patchPhotos(
//        @patchPhoto("albumId")albumId: String,
//        @field("thumbnailUrl")thumbnailUrl : String,
//    @field("id")id : Int,
//    @field("url")url : String
//    ): Call<PhotoRespon>
//
//    val albumId : String,
//    val id : Int,
//    val title: String,
//    val url: String,
//    val thumbnailUrl : String


    @FormUrlEncoded
    @DELETE("photos/{id}")
    fun deletePhoto(@Path("albumId") id: String): Call<Void>
    abstract fun Photo(): Any

}


