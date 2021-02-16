
package com.panzhiev.ipinfoapp

import com.panzhiev.ipinfoapp.di.AppComponent
import com.panzhiev.ipinfoapp.di.DaggerAppComponent
import dagger.android.DaggerApplication
import kotlin.time.ExperimentalTime

@ExperimentalTime
class IpInfoApplication : DaggerApplication() {

    override fun applicationInjector() = appComponent

    private val appComponent: AppComponent by lazy { DaggerAppComponent.factory().create(this) }
}