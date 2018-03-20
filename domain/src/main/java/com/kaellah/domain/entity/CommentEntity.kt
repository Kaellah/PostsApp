package com.kaellah.domain.entity

/**
 * @since 3/19/18
 */
data class CommentEntity constructor(val postId: Int,
                                     val id: Int,
                                     val name: String,
                                     val email: String,
                                     val body: String)