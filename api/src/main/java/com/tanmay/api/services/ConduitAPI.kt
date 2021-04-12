package com.tanmay.api.services

import com.tanmay.api.models.ArticleResponse
import com.tanmay.api.models.ArticlesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ConduitAPI {

    @GET("articles")
    fun getArticles(): Call<ArticlesResponse>
}