package com.tanmay.bloggingapp.data
import com.tanmay.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient().api
    suspend fun getGlobalFeed()=api.getArticles()
}