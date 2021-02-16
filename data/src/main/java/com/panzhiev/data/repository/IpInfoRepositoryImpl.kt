package com.panzhiev.data.repository

import com.panzhiev.data.ResultHandler
import com.panzhiev.data.apiservice.IpInfoApiService
import com.panzhiev.data.mapper.IpInfoMapper
import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.IpInfoRepository
import javax.inject.Inject

class IpInfoRepositoryImpl @Inject constructor(
    private val apiService: IpInfoApiService,
    private val mapper: IpInfoMapper,
    private val resultHandler: ResultHandler
) : IpInfoRepository {

    override suspend fun fetchIpInfo(ip: CharSequence): Result<CharSequence> =
        resultHandler {
            mapper.toDomain(apiService.fetchIpInfo(ip))
        }
}