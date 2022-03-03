package com.ausom.remote.model


import com.squareup.moshi.Json

data class PhotoListResponse(
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "pages")
    val pages: Int? = null,
    @Json(name = "perpage")
    val perpage: Int? = null,
    @Json(name = "photo")
    val photoResponse: List<PhotoResponse>? = null,
    @Json(name = "total")
    val total: Int? = null
)