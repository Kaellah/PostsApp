package com.kaellah.domain.interactor.comment

import com.kaellah.domain.entity.CommentEntity
import com.kaellah.domain.interactor.UseCase.SingleUseCase
import com.kaellah.domain.repository.PostsRepository
import io.reactivex.Single
import javax.inject.Inject


class GetCommentsUseCase @Inject constructor(private val repo: PostsRepository) : SingleUseCase<List<CommentEntity>> {

    var postId: Int = 0

    override fun execute(): Single<List<CommentEntity>> = repo.getComments(postId)
}