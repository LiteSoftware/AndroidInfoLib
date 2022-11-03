package com.udfsoft.androidinfo.lib.command.os

import com.udfsoft.androidinfo.lib.command.BaseGetCloudInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.os.MutableOSInformation
import com.udfsoft.androidinfo.lib.command.entity.os.OSIds
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationItemNetwork

class GetCloudOSInformationCommand(
    api: AndroidInfoApi
) : BaseGetCloudInformationCommand<MutableOSInformation>(
    api,
    MenuIds.MENU_ID_OS
) {

    override fun processInfo(
        item: DeviceInformationItemNetwork,
        entity: MutableOSInformation
    ) {
        when (item.id) {
            OSIds.OperatingSystem.id -> entity.operatingSystem = item.value
        }
    }
}