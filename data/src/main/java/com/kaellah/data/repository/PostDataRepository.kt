package com.kaellah.data.repository

import com.kaellah.data.api.PostsService
import com.kaellah.data.mapper.PostsMapper
import com.kaellah.data.util.handleApiException
import com.kaellah.domain.entity.PostEntity
import com.kaellah.domain.repository.PostsRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * @since 12/20/17
 */
class PostDataRepository(private val apiService: PostsService) : PostsRepository {

    override fun getPosts(): Single<List<PostEntity>> {
        return apiService
                .getPosts()
                .subscribeOn(Schedulers.io())
                .handleApiException()
                .map { PostsMapper.mapList(it, null) }
    }
}