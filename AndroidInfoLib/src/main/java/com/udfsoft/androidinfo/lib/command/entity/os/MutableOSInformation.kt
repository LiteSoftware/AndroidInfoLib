package com.udfsoft.androidinfo.lib.command.entity.os

import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.entity.OSInformation

data class MutableOSInformation(
    var manufacturer: String? = null,
    var version: Int = 0,
    var versionRelease: String? = null,
    var incremental: String? = null,
    var codeName: String? = null,
    var linuxVersion: String? = null,
    var operatingSystem: String? = null
) : MutableEntity<OSInformation> {

    override fun build() = OSInformation(
        manufacturer,
        version,
        versionRelease,
        incremental,
        codeName,
        linuxVersion,
        operatingSystem
    )
}
