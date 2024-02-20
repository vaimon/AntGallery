package me.vaimon.antgallery.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.vaimon.antgallery.data.models.UserData

@Database(entities = [UserData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "antGalleryDB"
    }
}