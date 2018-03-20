package com.kaellah.data.mapper

import com.kaellah.data.response.GeoResponse
import com.kaellah.domain.entity.GeoEntity
import com.kaellah.domain.util.Mapper


object GeoMapper : Mapper<GeoEntity, GeoResponse>() {

    override fun map(from: GeoResponse, payload: Any?): GeoEntity {
        return GeoEntity(from.lat, from.lng)
    }

    override fun reverseMap(to: GeoEntity, payload: Any?): GeoResponse {
        throw notImplementedException()
    }
}