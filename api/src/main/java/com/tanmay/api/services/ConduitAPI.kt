package com.tanmay.api.services

import com.tanmay.api.models.request.LoginRequest
import com.tanmay.api.models.request.SignupRequest
import com.tanmay.api.models.responses.ArticlesResponse
import com.tanmay.api.models.responses.TagsResponse
import com.tanmay.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

    @POST("users")
    suspend fun signupUser(
            @Body signupRequest: SignupRequest
    ):Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
            @Query("author") author: String?=null,
            @Query("favourited") favourited: String?=null,
            @Query("tag") tag: String?=null
    ): Response<ArticlesResponse>

    @POST("users")
    suspend fun loginUsers(
        @Body userCreds: LoginRequest
    ):Response<UserResponse>

    @GET("articles/{slug}")
    suspend fun getArticlesBySlug(
        @Path("slug") slug:String
    ):Response<ArticlesResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>
}