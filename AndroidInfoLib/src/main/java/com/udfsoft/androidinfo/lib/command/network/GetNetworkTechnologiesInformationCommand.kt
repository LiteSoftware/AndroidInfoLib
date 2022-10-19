package com.udfsoft.androidinfo.lib.command.network

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.entity.NetworkTechnologiesInformation
import com.udfsoft.androidinfo.lib.util.NetworkUtils

class GetNetworkTechnologiesInformationCommand(
    private val context: Context
) : CommandInterface<Unit, NetworkTechnologiesInformation> {

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    override fun invoke(param: Unit): NetworkTechnologiesInformation {
        val networkType = NetworkUtils.getNetworkType(context)
        val localIp = NetworkUtils.getLocalIpAddress()
        val mac =  NetworkUtils.getMACAddress(null)
        return NetworkTechnologiesInformation(networkType, localIp, mac)
    }
}