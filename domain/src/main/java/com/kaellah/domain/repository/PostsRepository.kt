package com.kaellah.domain.repository

import com.kaellah.domain.entity.CommentEntity
import com.kaellah.domain.entity.PostEntity
import com.kaellah.domain.entity.UserEntity
import io.reactivex.Single

/**
 * @since 3/19/18
 */
interface PostsRepository {

    fun getPosts(): Single<List<PostEntity>>

    fun getComments(postId: Int): Single<List<CommentEntity>>

    fun getUser(userId: Int): Single<UserEntity>
}