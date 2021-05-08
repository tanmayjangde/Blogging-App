package com.tanmay.api.models.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.tanmay.api.models.entities.UserUpdateData

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
        @Json(name = "user")
        val user: UserUpdateData
)