package com.kaellah.data.mapper

import com.kaellah.data.response.PostResponse
import com.kaellah.domain.entity.PostEntity
import com.kaellah.domain.util.Mapper


object PostsMapper : Mapper<PostEntity, PostResponse>() {

    override fun map(from: PostResponse, payload: Any?): PostEntity {
        return PostEntity(from.userId, from.id, from.title, from.body)
    }

    override fun reverseMap(to: PostEntity, payload: Any?): PostResponse {
        throw notImplementedException()
    }
}