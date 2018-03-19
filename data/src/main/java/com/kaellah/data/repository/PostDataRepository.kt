package com.kaellah.data.repository

import com.kaellah.data.api.PostsService
import com.kaellah.domain.entity.PostEntity
import com.kaellah.domain.repository.PostsRepository
import io.reactivex.Single

/**
 * @since 12/20/17
 */
class PostDataRepository(private val apiService: PostsService) : PostsRepository {

    override fun getPosts(page: Int): Single<List<PostEntity>> {
        return Single.never() // apiService.getPosts().subscribeOn(Schedulers.io())
    }
}