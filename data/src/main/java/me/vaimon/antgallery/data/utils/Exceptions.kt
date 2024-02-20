package me.vaimon.antgallery.data.utils

sealed class AuthorizationException(message: String?): Exception(){
    class UserNotFound(message: String? = null): AuthorizationException(message)
    class UserAlreadyExists(message: String? = null): AuthorizationException(message)
    class InvalidPassword(message: String? = null): AuthorizationException(message)
}
