package com.kaellah.data.api

import com.kaellah.data.response.CommentResponse
import com.kaellah.data.response.PostResponse
import com.kaellah.data.response.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @since 03/19/2018
 */
interface PostsService {

    @GET("posts")
    fun getPosts(): Single<List<PostResponse>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int): Single<List<CommentResponse>>

    @GET("users/{id}")
    fun getUser(@Path("id") userId: Int): Single<UserResponse>
}
