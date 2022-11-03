package com.udfsoft.androidinfo.lib.entity

import com.udfsoft.androidinfo.lib.util.NetworkUtils

data class NetworkTechnologiesInformation(
    val networkType: NetworkUtils.NetworkType,
    val localIp: String?,
    val mac: String?,
    val gsm: String?,
    val lte: String?,
    val mobileNetworkTechnologies: String?
)
