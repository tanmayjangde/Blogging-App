package com.tanmay.api.models.request


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.tanmay.api.models.entities.SignupData
import com.tanmay.api.models.entities.UserCreds

@JsonClass(generateAdapter = true)
data class SignupRequest(
    @Json(name = "user")
    val user: SignupData
)