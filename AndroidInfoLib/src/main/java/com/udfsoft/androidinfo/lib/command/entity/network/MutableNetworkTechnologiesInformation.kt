package com.udfsoft.androidinfo.lib.command.entity.network

import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.entity.NetworkTechnologiesInformation
import com.udfsoft.androidinfo.lib.util.NetworkUtils

data class MutableNetworkTechnologiesInformation(
    var networkType: NetworkUtils.NetworkType = NetworkUtils.NetworkType.UNKNOWN,
    var localIp: String? = null,
    var mac: String? = null,
    var gsm: String? = null,
    var lte: String? = null,
    var mobileNetworkTechnologies: String? = null
) : MutableEntity<NetworkTechnologiesInformation> {

    override fun build() = NetworkTechnologiesInformation(
        networkType,
        localIp,
        mac,
        gsm,
        lte,
        mobileNetworkTechnologies
    )
}
