package com.udfsoft.androidinfo.lib.entity

import com.udfsoft.androidinfo.lib.command.entity.sim.MutableSIMCardInformation

data class SIMCardInformation(
    val deviceSoftwareVersion: String?,
    val mobileNumber: String?,
    val simOperatorName: String?,
    val callState: Int,
    val simState: Int,
    val simCountryIso: String?,
    val isMultiSimSupported: Int,
    val simCardType: String?,
    val simCardsCount: Int
) {
    constructor(
        localEntity: MutableSIMCardInformation, networkEntity: MutableSIMCardInformation
    ) : this(
        localEntity.deviceSoftwareVersion,
        localEntity.mobileNumber,
        localEntity.simOperatorName,
        localEntity.callState,
        localEntity.simState,
        localEntity.simCountryIso,
        localEntity.isMultiSimSupported,
        networkEntity.simCardType,
        networkEntity.simCardsCount
    )
}
