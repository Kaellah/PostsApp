package com.kaellah.domain.entity

/**
 * @since 3/19/18
 */
data class AddressEntity constructor(val street: String,
                                     val suite: String,
                                     val city: String,
                                     val zipcode: String,
                                     val geo: GeoEntity)