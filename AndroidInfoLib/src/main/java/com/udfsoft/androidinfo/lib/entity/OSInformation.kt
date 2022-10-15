package com.udfsoft.androidinfo.lib.entity

data class OSInformation(
    val manufacturer: String,
    val version: Int,
    val versionRelease: String,
    val incremental: String,
    val codeName: String,
    val linuxVersion: String?
)
