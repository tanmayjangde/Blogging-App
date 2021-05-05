package com.tanmay.bloggingapp.data

import com.tanmay.api.ConduitClient
import com.tanmay.api.models.entities.LoginData
import com.tanmay.api.models.entities.SignupData
import com.tanmay.api.models.entities.User
import com.tanmay.api.models.request.LoginRequest
import com.tanmay.api.models.request.SignupRequest
import com.tanmay.api.models.responses.UserResponse

object UserRepo {

    val api = ConduitClient.publicApi
    val authApi = ConduitClient.authApi

    suspend fun login(email:String, password:String): User? {
        val response = api.loginUsers(LoginRequest(LoginData(email,password)))

        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

    suspend fun signup(username : String , email:String, password :String): User?{
        val response = api.signupUser(SignupRequest(SignupData(username,email, password)))
        ConduitClient.authToken=response.body()?.user?.token
        return response.body()?.user
    }

    suspend fun getUserProfile(){

    }
}