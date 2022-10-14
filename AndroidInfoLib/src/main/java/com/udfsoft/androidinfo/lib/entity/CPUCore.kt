package com.udfsoft.androidinfo.lib.entity

data class CPUCore(
    val id: Int,
    val bogoMIPS: Double,
    val features: String,
    val implementer: Int,
    val architecture: Int,
    val variant: Int,
    val part: Int,
    val revision: Int
)
