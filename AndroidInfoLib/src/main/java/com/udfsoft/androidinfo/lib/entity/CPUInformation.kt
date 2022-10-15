package com.udfsoft.androidinfo.lib.entity

data class CPUInformation(
    val type: String,
    val cores: List<CPUCore>
)
