package com.udfsoft.androidinfo.lib.entity

data class SIMCardInformation(
    val deviceSoftwareVersion: String?,
    val mobileNumber: String?,
    val simOperatorName: String?,
    val callState: Int,
    val simState: Int,
    val simCountryIso: String,
    val isMultiSimSupported: Int
)
