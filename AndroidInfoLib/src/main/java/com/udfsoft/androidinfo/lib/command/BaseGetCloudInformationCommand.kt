package com.udfsoft.androidinfo.lib.command

import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationItemNetwork

abstract class BaseGetCloudInformationCommand<P : MutableEntity<*>>(
    private val api: AndroidInfoApi,
    private val menuId: MenuIds
) : CommandInterface<P, P> {

    override fun invoke(param: P): P {
        val deviceInformation = api.getDeviceInfo(menuId.menuId).execute().body()
        deviceInformation?.deviceMenuItemList?.forEach {
            processInfo(it, param)
        }
        return param
    }

    protected abstract fun processInfo(item: DeviceInformationItemNetwork, entity: P)
}