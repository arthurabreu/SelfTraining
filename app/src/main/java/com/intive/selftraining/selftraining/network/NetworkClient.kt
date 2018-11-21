package com.intive.selftraining.selftraining.network

import com.intive.selftraining.selftraining.utils.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {

    var networkResponse: NetworkInterface = create()

    private fun create(): NetworkInterface {

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(AppConstants.URL)
            .client(getClient())
            .build()
        return retrofit.create(NetworkInterface::class.java)
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(KeyInterceptor).build()
    }
}