package com.kaellah.data.mapper

import com.kaellah.data.response.CompanyResponse
import com.kaellah.domain.entity.CompanyEntity
import com.kaellah.domain.util.Mapper


object CompanyMapper : Mapper<CompanyEntity, CompanyResponse>() {

    override fun map(from: CompanyResponse, payload: Any?): CompanyEntity {
        return CompanyEntity(from.name, from.catchPhrase, from.bs)
    }

    override fun reverseMap(to: CompanyEntity, payload: Any?): CompanyResponse {
        throw notImplementedException()
    }
}