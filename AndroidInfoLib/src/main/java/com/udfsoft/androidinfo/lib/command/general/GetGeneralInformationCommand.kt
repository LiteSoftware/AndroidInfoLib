package com.udfsoft.androidinfo.lib.command.general

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.entity.GeneralInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetGeneralInformationCommand(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, GeneralInformation> {

    override fun invoke(param: Unit): GeneralInformation {
        val getLocalGeneralInformationCommand = GetLocalGeneralInformationCommand()
        val localGeneralInformation = getLocalGeneralInformationCommand(Unit)
        val getNetworkGeneralInformationCommand = GetNetworkGeneralInformationCommand(api)
        val networkGeneralInformation = getNetworkGeneralInformationCommand(Unit)

        return GeneralInformation(localGeneralInformation, networkGeneralInformation)
    }
}