package me.vaimon.antgallery.mapper

import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.domain.entity.LoginCredentialsEntity
import me.vaimon.antgallery.models.User
import javax.inject.Inject

class UserCredentialsMapper @Inject constructor(): Mapper<User, LoginCredentialsEntity> {
    override fun from(e: LoginCredentialsEntity): User {
        throw UnsupportedOperationException()
    }

    override fun to(t: User): LoginCredentialsEntity {
        return LoginCredentialsEntity(
            t.email,
            t.password
        )
    }
}