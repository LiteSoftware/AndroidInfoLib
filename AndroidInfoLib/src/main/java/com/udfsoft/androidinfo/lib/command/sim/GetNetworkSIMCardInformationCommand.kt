package com.udfsoft.androidinfo.lib.command.sim

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.sim.MutableSIMCardInformation
import com.udfsoft.androidinfo.lib.command.entity.sim.SIMIds
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetNetworkSIMCardInformationCommand(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, MutableSIMCardInformation> {

    override fun invoke(param: Unit): MutableSIMCardInformation {
        val mutableEntity = MutableSIMCardInformation()
        val deviceInformation = api.getDeviceInfo(MenuIds.MENU_ID_SIM.menuId).execute().body()
        deviceInformation?.deviceMenuItemList?.forEach {
            when (it.id) {
                SIMIds.SIMCardType.id -> mutableEntity.simCardType = it.value
                SIMIds.SIMCardsCount.id -> mutableEntity.simCardsCount =
                    it.value?.toIntOrNull() ?: 0
            }
        }

        return mutableEntity
    }
}