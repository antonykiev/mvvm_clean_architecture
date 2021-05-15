package com.example.cleanarchitecture

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import com.example.cleanarchitecture.data.di.dataModules
import com.example.cleanarchitecture.domain.di.domainModules
import com.example.cleanarchitecture.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(domainModules + presentationModule + dataModules)
        }

        Coil.setDefaultImageLoader(
            ImageLoader(this) {
                componentRegistry {
                    add(GifDecoder())
                }
            }
        )
    }
}