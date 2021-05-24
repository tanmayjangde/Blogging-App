package com.tanmay.bloggingapp.data

import com.tanmay.api.ConduitClient
import com.tanmay.api.models.entities.LoginData
import com.tanmay.api.models.entities.SignupData
import com.tanmay.api.models.entities.User
import com.tanmay.api.models.entities.UserUpdateData
import com.tanmay.api.models.request.LoginRequest
import com.tanmay.api.models.request.SignupRequest
import com.tanmay.api.models.request.UserUpdateRequest

object UserRepo {

    val api = ConduitClient.publicApi
    val authApi = ConduitClient.authApi

    suspend fun login(email:String, password:String): User? {
        val response = api.loginUser(LoginRequest(LoginData(email,password)))

        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

    suspend fun signup(username : String , email:String, password :String): User?{
        val response = api.signupUser(SignupRequest(SignupData(username,email, password)))
        ConduitClient.authToken=response.body()?.user?.token
        return response.body()?.user
    }

    suspend fun updateUser(
            bio: String?,
            username: String?,
            image: String?,
            email: String?,
            password: String?
    ): User? {
        val response = authApi.updateCurrentUser(UserUpdateRequest(UserUpdateData(
                bio, email, image, username, password
        )))

        return response.body()?.user
    }

    suspend fun getCurrentUser(token: String): User? {
        ConduitClient.authToken = token
        return authApi.getCurrentUser().body()?.user
    }

}