package com.oriol.recuandroid.Common

import com.oriol.recuandroid.Network.APIService
import com.oriol.recuandroid.Network.Retrofit

object Common {
    private const val BASE_URL = "http://serveranimalutad-env.eba-zr9dsz3t.eu-west-3.elasticbeanstalk.com/"
    val getApiService: APIService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}