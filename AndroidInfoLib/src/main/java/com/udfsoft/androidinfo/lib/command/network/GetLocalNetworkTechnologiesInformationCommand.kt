package com.udfsoft.androidinfo.lib.command.network

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import com.udfsoft.androidinfo.lib.command.BaseGetLocalInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.network.MutableNetworkTechnologiesInformation
import com.udfsoft.androidinfo.lib.util.NetworkUtils

class GetLocalNetworkTechnologiesInformationCommand(
    private val context: Context
) : BaseGetLocalInformationCommand<MutableNetworkTechnologiesInformation>() {

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    override fun invoke(param: MutableNetworkTechnologiesInformation): MutableNetworkTechnologiesInformation {
        param.networkType = NetworkUtils.getNetworkType(context)
        param.localIp = NetworkUtils.getLocalIpAddress()
        param.mac = NetworkUtils.getMACAddress(null)

        return param
    }
}