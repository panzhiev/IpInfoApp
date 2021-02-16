package com.panzhiev.data.apiservice

import com.panzhiev.data.model.IpInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

private const val ALL_IP_FIELDS_NUMERIC = 66846719

interface IpInfoApiService {

    @GET("json/{ip}?fields=$ALL_IP_FIELDS_NUMERIC")
    suspend fun fetchIpInfo(@Path("ip") ip: CharSequence): IpInfoResponse
}