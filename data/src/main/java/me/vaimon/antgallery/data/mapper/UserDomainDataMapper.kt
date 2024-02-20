package me.vaimon.antgallery.data.mapper

import me.vaimon.antgallery.data.models.UserData
import me.vaimon.antgallery.domain.entity.UserEntity
import javax.inject.Inject

class UserDomainDataMapper @Inject constructor(): Mapper<UserEntity, UserData> {
    override fun from(e: UserData): UserEntity {
        return UserEntity(
            name = e.name,
            birthDay = e.birthDay,
            phone = e.phone,
            email = e.email,
            password = null
        )
    }

    override fun to(t: UserEntity): UserData {
        return UserData(
            name = t.name,
            birthDay = t.birthDay,
            phone = t.phone,
            email = t.email,
            password = t.password
        )
    }
}