package com.ekspansion.eks.info

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache


class AppApplication : Application(), ImageLoaderFactory {

    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { (database.informationDAO()) }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.25)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(filesDir.resolve("image_cache"))
                    .build()
            }
            .build()
    }
}