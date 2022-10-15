package com.udfsoft.androidinfo.lib.mapper

import com.udfsoft.androidinfo.lib.command.entity.LocalCPUCore
import com.udfsoft.androidinfo.lib.entity.CPUCore

class LocalCoreToCoreMapper : MapperInterface<LocalCPUCore, CPUCore> {

    override fun invoke(param: LocalCPUCore) = CPUCore(
        param.id,
        param.bogoMIPS,
        param.features ?: "",
        param.implementer,
        param.architecture,
        param.variant,
        param.part,
        param.revision
    )
}