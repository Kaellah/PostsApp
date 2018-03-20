package com.kaellah.domain.entity

/**
 * @since 3/19/18
 */
data class UserEntity constructor(val id: Int,
                                  val name: String,
                                  val username: String,
                                  val email: String,
                                  val address: AddressEntity,
                                  val phone: String,
                                  val website: String,
                                  val company: CompanyEntity
)