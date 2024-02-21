package me.vaimon.antgallery.data.datasource

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SharedPreferencesDataSource @Inject constructor(
    @ApplicationContext context: Context
) {
    companion object{
        private const val sharedPrefsFileName = "me.vaimon.antgallery.AntPrefs"
        private const val loggedUserIdKey = "LOGGED_USER_ID"
    }

    private val sharedPrefs = context.getSharedPreferences(
        sharedPrefsFileName,
        Context.MODE_PRIVATE
    )

    fun getLoggedUserId(): Int? = sharedPrefs.all[loggedUserIdKey] as Int?

    fun setLoggedUserId(userId: Int) = sharedPrefs.edit {
        putInt(loggedUserIdKey, userId)
    }

    fun clearUserId() = sharedPrefs.edit {
        remove(loggedUserIdKey)
    }
}