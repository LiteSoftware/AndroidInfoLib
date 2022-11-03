package com.udfsoft.androidinfo.lib.command.os

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresPermission
import com.udfsoft.androidinfo.lib.command.BaseGetLocalInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.os.MutableOSInformation

class GetLocalOSInformationCommand : BaseGetLocalInformationCommand<MutableOSInformation>() {

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    override fun invoke(param: MutableOSInformation) {
        param.manufacturer = Build.MANUFACTURER
        param.version = Build.VERSION.SDK_INT
        param.versionRelease = Build.VERSION.RELEASE
        param.incremental = Build.VERSION.INCREMENTAL
        param.codeName = Build.VERSION.CODENAME
        param.linuxVersion = System.getProperty("os.version")
    }
}