package com.ausom.remote.model


import com.squareup.moshi.Json

data class FlickrResponse(
    @Json(name = "photos")
    val photoListResponse: PhotoListResponse? = null,
    @Json(name = "stat")
    val stat: String? = null
)