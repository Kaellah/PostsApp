package com.kaellah.domain.interactor.comment

import com.kaellah.domain.entity.UserEntity
import com.kaellah.domain.interactor.UseCase.SingleUseCase
import com.kaellah.domain.repository.PostsRepository
import io.reactivex.Single
import javax.inject.Inject


class GetUserUseCase @Inject constructor(private val repo: PostsRepository) : SingleUseCase<UserEntity> {

    var userId: Int = 0

    override fun execute(): Single<UserEntity> = repo.getUser(userId)
}