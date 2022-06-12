package com.oriol.recuandroid.Network

import com.oriol.recuandroid.Model.Animals
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("animals")
    fun getAnimalsList(): Call<MutableList<Animals>>
}