package com.kaellah.domain.interactor.post

import com.kaellah.domain.entity.PostEntity
import com.kaellah.domain.interactor.UseCase.SingleUseCase
import com.kaellah.domain.repository.PostsRepository
import io.reactivex.Single
import javax.inject.Inject


class GetPostsUseCase @Inject constructor(private val repo: PostsRepository) : SingleUseCase<List<PostEntity>> {

    override fun execute(): Single<List<PostEntity>> = repo.getPosts()
}