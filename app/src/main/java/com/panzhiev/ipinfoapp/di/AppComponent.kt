package com.panzhiev.ipinfoapp.di

import android.app.Application
import com.panzhiev.ipinfoapp.IpInfoApplication
import com.panzhiev.ipinfoapp.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton
import kotlin.time.ExperimentalTime

@ExperimentalTime
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        GsonModule::class,
        RepositoryModule::class,
        ActivitiesModule::class
    ]
)
interface AppComponent : AndroidInjector<IpInfoApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}