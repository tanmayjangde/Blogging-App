package com.tanmay.api.services

import com.tanmay.api.models.request.UserUpdateRequest
import com.tanmay.api.models.responses.ArticlesResponse
import com.tanmay.api.models.responses.ProfileResponse
import com.tanmay.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthAPI {

    @GET("user")
    suspend fun getCurrentUser():Response<UserResponse>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest: UserUpdateRequest
    ):Response<UserResponse>

    @GET("profile/{username}")
    suspend fun getProfile(
            @Path("username")username:String
    ): Response<ProfileResponse>

    @POST("profile/{username}/follow")
    suspend fun followProfile(
            @Path("username")username:String
    ):Response<ProfileResponse>

    @DELETE("profile/{username}/follow")
    suspend fun unFollowProfile(
            @Path("username")username:String
    ):Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles(): Response<ArticlesResponse>

    @POST("articles/{slug}/favourite")
    suspend fun favoriteArticles(
            @Path("slug")slug:String
    ):Response<ArticlesResponse>

    @DELETE("articles/{slug}/favourite")
    suspend fun unfavouriteArticle(
            @Path("slug")slug:String
    ):Response<ArticlesResponse>

}