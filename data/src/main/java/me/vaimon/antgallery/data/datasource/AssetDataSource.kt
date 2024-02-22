package me.vaimon.antgallery.data.datasource

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import me.vaimon.antgallery.data.models.PictureData
import java.time.LocalDateTime
import javax.inject.Inject

class AssetDataSource  @Inject constructor(
    @ApplicationContext context: Context
) {
    private val assetManager = context.assets

    suspend fun getDummiePictures(): List<PictureData>{
        delay(2000L)
        val lst = assetManager.list("stubs/")?.map {
            PictureData(
                "file:///android_asset/stubs/$it",
                "Lorem ipsum $it",
                "Lorem ipsum dolor sit amet",
                1,
                LocalDateTime.now()
            )
        }
        return lst?.shuffled() ?: listOf()
    }
}