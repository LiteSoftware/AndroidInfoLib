package com.udfsoft.androidinfo.lib.command.entity.sim

data class MutableSIMCardInformation(
    var deviceSoftwareVersion: String? = null,
    var mobileNumber: String? = null,
    var simOperatorName: String? = null,
    var callState: Int = 0,
    var simState: Int = 0,
    var simCountryIso: String? = null,
    var isMultiSimSupported: Int = 0,
    var simCardType: String? = null,
    var simCardsCount: Int = 0
)
