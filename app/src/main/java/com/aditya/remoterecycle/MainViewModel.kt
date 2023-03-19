package com.aditya.remoterecycle

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _photo = MutableLiveData<List<Photo>>()
    val photo : LiveData<List<Photo>> = _photo

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading


    init {
        getPhoto()
    }


   private fun getPhoto() {
       _isLoading.value = true
        val client = ApiConfig.getApiService().getPhotos()
        client.enqueue(object  : retrofit2.Callback<List<Photo>>{
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful){
                    _isLoading.value = false
                    val responseBody = response.body()
                    if (responseBody != null) {
                       _photo.value = responseBody
                    }
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                _isLoading.value = false
               Log.d("Respons::::::::",t.message.toString())
            }

        })
    }



}