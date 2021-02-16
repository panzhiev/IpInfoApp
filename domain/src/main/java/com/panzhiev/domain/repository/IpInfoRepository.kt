package com.panzhiev.domain.repository

import com.panzhiev.domain.model.Result

interface IpInfoRepository {

    suspend fun fetchIpInfo(ip: CharSequence): Result<CharSequence>

}