package com.panzhiev.ipinfoapp.di.module

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.panzhiev.data.apiservice.IpInfoApiService
import com.panzhiev.ipinfoapp.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

private const val BASE_URL = "base_url"
private const val TIME_OUT = 30L

@Module
class NetworkModule {

    @Provides
    @Named(BASE_URL)
    fun baseUrl() = BuildConfig.BASE_URL

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()

    @Provides
    fun converterFactory(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    fun provideRetrofit(
        @Named(BASE_URL) baseUrl: String,
        client: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    @Provides
    fun provideIpInfoApiService(retrofit: Retrofit): IpInfoApiService =
        retrofit.create(IpInfoApiService::class.java)
}