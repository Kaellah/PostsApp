package com.kaellah.data.mapper

import com.kaellah.data.response.UserResponse
import com.kaellah.domain.entity.UserEntity
import com.kaellah.domain.util.Mapper


object UserMapper : Mapper<UserEntity, UserResponse>() {

    override fun map(from: UserResponse, payload: Any?): UserEntity {
        return UserEntity(from.id,
                          from.name,
                          from.username,
                          from.email,
                          AddressMapper.map(from.address, null),
                          from.phone,
                          from.website,
                          CompanyMapper.map(from.company, null)
        )
    }

    override fun reverseMap(to: UserEntity, payload: Any?): UserResponse {
        throw notImplementedException()
    }
}