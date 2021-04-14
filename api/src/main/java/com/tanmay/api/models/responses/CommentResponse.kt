package com.tanmay.api.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.tanmay.api.models.entities.Comment

@JsonClass(generateAdapter = true)
data class CommentResponse(
    @Json(name = "comments")
    val comments: List<Comment>
)