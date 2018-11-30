package com.intive.selftraining.selftraining.data

import android.util.Log
import com.google.gson.Gson
import com.intive.selftraining.selftraining.network.errors.ResourceNotBeFound
import io.reactivex.Observable
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class NetworkException(error: Throwable) : RuntimeException(error)

class NoNetworkException(error: Throwable) : NetworkException(error)

class ServerUnreachableException(error: Throwable) : NetworkException(error)

class HttpCallFailureException(error: Throwable) : NetworkException(error) {
    init {
        val body = (error as HttpException).response().errorBody()
        val gson = Gson()
        val adapter = gson.getAdapter<ResourceNotBeFound>(ResourceNotBeFound::class.java)
        try {
            val errorParser = adapter.fromJson(body?.string())

            Log.i("HANDLE_EXCEPTION", "Error body message:" + errorParser.status_message)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

fun <T> Observable<T>.mapNetworkErrors(): Observable<T> =
    this.doOnError { error ->
        when (error) {
            is SocketTimeoutException -> Observable.error<NoNetworkException>(NoNetworkException(error))
            is UnknownHostException -> Observable.error<ServerUnreachableException>(ServerUnreachableException(error))
            is HttpException -> Observable.error<HttpCallFailureException> { HttpCallFailureException(error) }
            else -> Observable.error(error)
        }
    }