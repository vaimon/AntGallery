package me.vaimon.antgallery.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import me.vaimon.antgallery.data.converters.LocalDateConverter
import java.time.LocalDate

@Entity(tableName = "users")
@TypeConverters(LocalDateConverter::class)
data class UserData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val birthDay: LocalDate?,
    val phone: String,
    val email: String,
    val password: String?
)
