package me.vaimon.antgallery.data.converters

import androidx.room.TypeConverter
import java.time.LocalDate

object LocalDateConverter{
    @TypeConverter
    fun fromLong(epoch: Long?): LocalDate? {
        return if (epoch == null) null else LocalDate.ofEpochDay(epoch)
    }

    @TypeConverter
    fun localDateToEpoch(localDate: LocalDate?): Long? {
        return localDate?.toEpochDay()
    }
}