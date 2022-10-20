package com.udfsoft.androidinfo.lib.command.general

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.GeneralIds
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.general.NetworkGeneralInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetNetworkGeneralInformationCommand(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, NetworkGeneralInformation> {

    override fun invoke(param: Unit): NetworkGeneralInformation {
        var brand: String? = null
        var model: String? = null
        var modelAlias: String? = null
        val deviceInformation = api.getDeviceInfo(MenuIds.MENU_ID_GENERAL.menuId).execute().body()
        deviceInformation?.deviceMenuItemList?.forEach {
            when (it.id) {
                GeneralIds.BRAND.id -> brand = it.value
                GeneralIds.MODEL.id -> model = it.value
                GeneralIds.MODEL_ALIAS.id -> modelAlias = it.value
            }
        }
        return NetworkGeneralInformation(brand, model, modelAlias)
    }
}