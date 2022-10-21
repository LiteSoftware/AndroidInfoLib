package com.udfsoft.androidinfo.lib.command.network

import com.udfsoft.androidinfo.lib.command.BaseGetCloudInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.network.MutableNetworkTechnologiesInformation
import com.udfsoft.androidinfo.lib.command.entity.network.NetworkTechnologiesIds
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationItemNetwork

class GetCloudNetworkTechnologiesInformationCommand(
    api: AndroidInfoApi
) : BaseGetCloudInformationCommand<MutableNetworkTechnologiesInformation>(
    api,
    MenuIds.MENU_ID_MOBILE_NETWORK
) {

    override fun processInfo(
        item: DeviceInformationItemNetwork,
        entity: MutableNetworkTechnologiesInformation
    ) {
        when (item.id) {
            NetworkTechnologiesIds.GSM.id -> entity.gsm = item.value
            NetworkTechnologiesIds.LTE.id -> entity.lte = item.value
            NetworkTechnologiesIds.NetworkTechnologies.id ->
                entity.mobileNetworkTechnologies = item.value
        }
    }
}