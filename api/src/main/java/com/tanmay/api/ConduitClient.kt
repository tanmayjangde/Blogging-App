package com.tanmay.api

import com.tanmay.api.services.ConduitAPI
import com.tanmay.api.services.ConduitAuthAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClient {

    var authToken : String ?= null

    private val authInterceptor = Interceptor{ chain->
        var req = chain.request()
        authToken?.let{
            req = req.newBuilder()
                    .header("Authorisation","Token $it")
                    .build()
        }
        chain.proceed(req)
    }

    val okHttpBuilder = OkHttpClient.Builder()
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(2,TimeUnit.SECONDS)

    val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())

    val publicApi = retrofitBuilder
            .client(okHttpBuilder.build())
            .build()
            .create(ConduitAPI::class.java)

    val authApi = retrofitBuilder
            .client(okHttpBuilder.addInterceptor(authInterceptor).build())
            .build()
            .create(ConduitAuthAPI::class.java)
}