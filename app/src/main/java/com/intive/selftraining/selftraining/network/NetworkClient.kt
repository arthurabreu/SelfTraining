package com.intive.selftraining.selftraining.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {

        private val client = OkHttpClient().newBuilder().addInterceptor(KeyInterceptor).build()

//        init {
//            create(AppConstants.url)
//        }

        fun create(url: String): NetworkInterface {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .client(client)
                .build()

            return retrofit.create(NetworkInterface::class.java)
        }
}