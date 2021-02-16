package com.panzhiev.ipinfoapp.di.module

import com.panzhiev.data.repository.IpInfoRepositoryImpl
import com.panzhiev.domain.repository.IpInfoRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun ipInfoRepository(repository: IpInfoRepositoryImpl): IpInfoRepository
}