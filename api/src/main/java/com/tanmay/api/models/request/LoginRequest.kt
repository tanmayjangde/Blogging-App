package com.tanmay.api.models.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.tanmay.api.models.entities.LoginData
import com.tanmay.api.models.entities.UserCreds

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val user: LoginData
)