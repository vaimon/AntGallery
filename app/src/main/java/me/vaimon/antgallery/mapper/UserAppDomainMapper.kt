package me.vaimon.antgallery.mapper

import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.models.User
import javax.inject.Inject

class UserAppDomainMapper @Inject constructor(): Mapper<User, UserEntity> {
    override fun from(e: UserEntity): User {
        return User(
            name = e.name,
            birthDay = e.birthDay,
            phone = e.phone,
            email = e.email,
            password = e.password ?: ""
        )
    }

    override fun to(t: User): UserEntity {
        return UserEntity(
            name = t.name,
            birthDay = t.birthDay,
            phone = t.phone,
            email = t.email,
            password = t.password
        )
    }
}