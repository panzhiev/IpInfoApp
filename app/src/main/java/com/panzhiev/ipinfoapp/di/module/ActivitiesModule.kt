package com.panzhiev.ipinfoapp.di.module

import com.panzhiev.ui.ip_info.MainActivity
import com.panzhiev.ipinfoapp.di.annotation.PerActivity
import com.panzhiev.ui.ip_info.ui.IpInfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivitiesModule {

    @PerActivity
    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector
    fun ipInfoFragment(): IpInfoFragment
}