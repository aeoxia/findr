package com.ausom.remote.model


import com.squareup.moshi.Json

data class PhotoResponse(
    @Json(name = "farm")
    val farm: Int? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "isfamily")
    val isfamily: Int? = null,
    @Json(name = "isfriend")
    val isfriend: Int? = null,
    @Json(name = "ispublic")
    val ispublic: Int? = null,
    @Json(name = "owner")
    val owner: String? = null,
    @Json(name = "secret")
    val secret: String? = null,
    @Json(name = "server")
    val server: String? = null,
    @Json(name = "title")
    val title: String? = null
)