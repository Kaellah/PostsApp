package com.kaellah.data.mapper

import com.kaellah.data.response.CommentResponse
import com.kaellah.domain.entity.CommentEntity
import com.kaellah.domain.util.Mapper


object CommentsMapper : Mapper<CommentEntity, CommentResponse>() {

    override fun map(from: CommentResponse, payload: Any?): CommentEntity {
        return CommentEntity(from.postId, from.id, from.name, from.email, from.body)
    }

    override fun reverseMap(to: CommentEntity, payload: Any?): CommentResponse {
        throw notImplementedException()
    }
}