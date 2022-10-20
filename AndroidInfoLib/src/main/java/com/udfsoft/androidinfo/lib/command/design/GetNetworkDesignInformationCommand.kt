package com.udfsoft.androidinfo.lib.command.design

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.design.DesignIds
import com.udfsoft.androidinfo.lib.command.entity.design.MutableDesignInformation
import com.udfsoft.androidinfo.lib.entity.DesignInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetNetworkDesignInformationCommand(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, DesignInformation> {

    override fun invoke(param: Unit): DesignInformation {
        val mutableEntity = MutableDesignInformation()
        val deviceInformation = api.getDeviceInfo(MenuIds.MENU_ID_DESIGN.menuId).execute().body()
        deviceInformation?.deviceMenuItemList?.forEach {
            when (it.id) {
                DesignIds.Width.id -> mutableEntity.width = it.value
                DesignIds.Height.id -> mutableEntity.height = it.value
                DesignIds.Weight.id -> mutableEntity.weight = it.value
                DesignIds.Colors.id -> mutableEntity.colors = it.value
                DesignIds.Volume.id -> mutableEntity.volume = it.value
                DesignIds.BodyMaterials.id -> mutableEntity.bodyMaterials = it.value
            }
        }
        return DesignInformation(mutableEntity)
    }
}