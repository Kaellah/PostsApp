package com.kaellah.domain.entity

/**
 * @since 3/19/18
 */
data class PostEntity constructor(val userId: String,
                                  val id: String,
                                  val title: String,
                                  val body: String)