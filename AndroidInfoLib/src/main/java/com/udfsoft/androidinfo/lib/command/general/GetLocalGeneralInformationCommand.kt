package com.udfsoft.androidinfo.lib.command.general

import android.os.Build
import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.general.LocalGeneralInformation

class GetLocalGeneralInformationCommand : CommandInterface<Unit, LocalGeneralInformation> {

    override fun invoke(param: Unit) = LocalGeneralInformation(Build.BRAND, Build.MODEL)
}