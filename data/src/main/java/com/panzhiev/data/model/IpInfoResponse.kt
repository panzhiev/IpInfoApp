package com.panzhiev.data.model

import com.google.gson.annotations.SerializedName

data class IpInfoResponse(
    @SerializedName("as") val autonomousSystem: String,
    @SerializedName("asname") val asName: String,
    val city: String,
    val continent: String,
    val continentCode: String,
    val country: String,
    val countryCode: String,
    val currency: String,
    val district: String,
    val hosting: Boolean,
    val isp: String,
    val lat: Double,
    val lon: Double,
    val mobile: Boolean,
    val offset: Int,
    val org: String,
    val proxy: Boolean,
    val query: String,
    val region: String,
    val regionName: String,
    val reverse: String,
    val status: String,
    val timezone: String,
    val zip: String,
    val message: String,
)