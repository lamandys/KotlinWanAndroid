package com.lamandys.basic.factory

import android.app.Application
import com.lamandys.basic.http.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by lamandys on 2020/3/6 6:15 PM.
 */
fun Application.initHttp() {
    HttpFactory.getInstance().init(this)
}

class HttpFactory {

    private object HttpFactoryHolder {
        val instance = HttpFactory()
    }

    companion object {
        fun getInstance(): HttpFactory {
            return HttpFactoryHolder.instance
        }
    }

    private lateinit var retrofit: Retrofit

    fun init(application: Application) {
        retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.Base_Http_Url)
            .client(createRetrofit())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createRetrofit(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    fun <T> getApiServer(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

}