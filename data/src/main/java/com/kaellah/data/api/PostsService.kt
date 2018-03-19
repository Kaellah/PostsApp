package com.kaellah.data.api

//import com.kaellah.data.response.MoviesListResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @since 03/19/2018
 */
interface PostsService {

//    @GET("movie/now_playing")
//    fun getPosts(@Query("api_key") apiKey: String, @Query("page") page: Int): Single<Any>

    @GET("posts")
    fun getPosts(): Single<Any>
}
