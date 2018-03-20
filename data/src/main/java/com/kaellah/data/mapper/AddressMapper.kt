package com.kaellah.data.mapper

import com.kaellah.data.response.AddressResponse
import com.kaellah.domain.entity.AddressEntity
import com.kaellah.domain.util.Mapper


object AddressMapper : Mapper<AddressEntity, AddressResponse>() {

    override fun map(from: AddressResponse, payload: Any?): AddressEntity {
        return AddressEntity(from.street,
                             from.suite,
                             from.city,
                             from.zipcode,
                             GeoMapper.map(from.geo, null))
    }

    override fun reverseMap(to: AddressEntity, payload: Any?): AddressResponse {
        throw notImplementedException()
    }
}