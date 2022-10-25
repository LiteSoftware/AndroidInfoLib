package com.udfsoft.androidinfo.lib.command.entity.gpu

import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.entity.GPUInformation

data class MutableGPUInformation(
    var name: String? = null
) : MutableEntity<GPUInformation> {

    override fun build() = GPUInformation(name)
}
