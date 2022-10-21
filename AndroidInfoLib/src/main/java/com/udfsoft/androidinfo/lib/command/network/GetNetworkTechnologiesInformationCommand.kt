package com.udfsoft.androidinfo.lib.command.network

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.network.MutableNetworkTechnologiesInformation
import com.udfsoft.androidinfo.lib.entity.NetworkTechnologiesInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetNetworkTechnologiesInformationCommand(
    private val context: Context,
    val api: AndroidInfoApi
) : CommandInterface<Unit, NetworkTechnologiesInformation> {

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    override fun invoke(param: Unit): NetworkTechnologiesInformation {
        val mutableEntity = MutableNetworkTechnologiesInformation()
        GetLocalNetworkTechnologiesInformationCommand(context).invoke(mutableEntity)
        GetCloudNetworkTechnologiesInformationCommand(api).invoke(mutableEntity)
        return mutableEntity.build()
    }
}