package com.udfsoft.androidinfo.lib.command.os

import android.Manifest
import androidx.annotation.RequiresPermission
import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.os.MutableOSInformation
import com.udfsoft.androidinfo.lib.entity.OSInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetOSInformationCommand(val api: AndroidInfoApi) : CommandInterface<Unit, OSInformation> {

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    override fun invoke(param: Unit): OSInformation {
        val mutableEntity = MutableOSInformation()
        GetLocalOSInformationCommand().invoke(mutableEntity)
        GetCloudOSInformationCommand(api).invoke(mutableEntity)

        return mutableEntity.build()
    }
}