package com.oriol.recuandroid.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.oriol.recuandroid.Common.Common
import com.oriol.recuandroid.Model.Animals
import com.oriol.recuandroid.Network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositorie {
    private val apiService: APIService = Common.getApiService

    companion object {
        private const val TAG = "MainRepositorie"
    }


    val getAnimalsLiveData: MutableLiveData<MutableList<Animals>>
        get() {
            val data: MutableLiveData<MutableList<Animals>> =
                MutableLiveData<MutableList<Animals>>()
            apiService.getAnimalsList().enqueue(object : Callback<MutableList<Animals>> {
                override fun onResponse(
                    call: Call<MutableList<Animals>>,
                    response: Response<MutableList<Animals>>
                ) {
                    Log.e(TAG, "onResponse: " + response.code())
                    if (response.isSuccessful) {
                        data.value = response.body()
                    } else {
                        data.value = null
                    }
                }

                override fun onFailure(call: Call<MutableList<Animals>>, t: Throwable) {
                    Log.e(TAG, "onResponse: " + t.message)
                    data.value = null
                }
            })
            return data
        }

}