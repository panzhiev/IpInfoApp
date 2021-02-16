package com.panzhiev.domain.usecase

import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.IpInfoRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class FetchIpInfoUseCase @Inject constructor(
    private val repository: IpInfoRepository
) {
    suspend operator fun invoke(ip: CharSequence): Result<CharSequence> = repository.fetchIpInfo(ip)
}