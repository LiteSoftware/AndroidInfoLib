package com.udfsoft.androidinfo.lib.command

import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationNetwork

abstract class BaseGetNetworkInformationCommand<P, R>(
    private val api: AndroidInfoApi,
    private val menuId: Int
) : CommandInterface<P, R> {

    override fun invoke(param: P): R {
        val deviceInformation = api.getDeviceInfo(menuId).execute().body()
        return processInfo(deviceInformation, param)
    }

    abstract fun processInfo(item: DeviceInformationNetwork?, param: P): R
}