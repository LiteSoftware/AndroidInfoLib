package com.udfsoft.androidinfo.lib.command.gpu

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.gpu.MutableGPUInformation
import com.udfsoft.androidinfo.lib.entity.GPUInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetGPUInformationCommand(
    val api: AndroidInfoApi
) : CommandInterface<Unit, GPUInformation> {

    override fun invoke(param: Unit): GPUInformation {
        val mutableEntity = MutableGPUInformation()
        GetCloudGPUInformation(api).invoke(mutableEntity)
        return mutableEntity.build()
    }
}