package com.panzhiev.data.mapper

import com.google.gson.GsonBuilder
import com.panzhiev.data.model.IpInfoResponse
import javax.inject.Inject

class IpInfoMapper @Inject constructor() {

    fun toDomain(ipInfoResponse: IpInfoResponse): CharSequence =
        GsonBuilder().setPrettyPrinting().create().toJson(ipInfoResponse)
}