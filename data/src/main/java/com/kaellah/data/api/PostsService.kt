package com.kaellah.data.api

import com.kaellah.data.response.PostResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @since 03/19/2018
 */
interface PostsService {

    @GET("posts")
    fun getPosts(): Single<List<PostResponse>>
}
