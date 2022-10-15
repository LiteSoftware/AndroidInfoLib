package com.udfsoft.androidinfo.lib.command

import android.os.Build
import com.udfsoft.androidinfo.lib.entity.OSInformation

class GetOSInformationCommand : CommandInterface<Unit, OSInformation> {

    override fun invoke(param: Unit): OSInformation {
        val manufacturer = Build.MANUFACTURER
        val version = Build.VERSION.SDK_INT
        val versionRelease = Build.VERSION.RELEASE
        val incremental = Build.VERSION.INCREMENTAL
        val codeName = Build.VERSION.CODENAME
        val linuxVersion = System.getProperty("os.version")

        return OSInformation(manufacturer, version, versionRelease, incremental, codeName, linuxVersion)
    }
}