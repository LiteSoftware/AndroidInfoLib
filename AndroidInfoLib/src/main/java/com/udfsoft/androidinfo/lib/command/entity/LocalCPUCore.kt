package com.udfsoft.androidinfo.lib.command.entity

data class LocalCPUCore(
    var id: Int = 0,
    var bogoMIPS: Double = 0.0,
    var features: String? = null,
    var implementer: Int = 0,
    var architecture: Int = 0,
    var variant: Int = 0,
    var part: Int = 0,
    var revision: Int = 0
)
