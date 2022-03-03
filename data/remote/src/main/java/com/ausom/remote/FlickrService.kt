package com.ausom.remote

import com.ausom.remote.model.FlickrResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Service used for API call
 */
interface FlickrService {

    /**
     * method and api key can be passed as parameters
     * but for now since this is the only used endpoint I will shorten it this way
     * */
    @GET("services/rest/?method=flickr.photos.search&api_key=96358825614a5d3b1a1c3fd87fca2b47&format=json&nojsoncallback=1")
    suspend fun getImages(
        @Query("text") keyword: String,
        @Query("page") page: Int,
    ) : FlickrResponse

}