package br.com.jvictororiz.startermvp

import android.app.Application
import br.com.jvictororiz.startermvp.data.dao.databaseConfig.AplicationDatabase
import br.com.jvictororiz.startermvp.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class BaseApplication : Application() {
    open fun getApiUrl(): String {
        return BuildConfig.SERVER_URL
    }

    open fun getNameDatabase(): String {
        return AplicationDatabase.NAME
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger()
            modules(
                listOf(
                    applicationModule,
                    repositoryModule,
                    databaseModules
                )
            )
        }
    }
}