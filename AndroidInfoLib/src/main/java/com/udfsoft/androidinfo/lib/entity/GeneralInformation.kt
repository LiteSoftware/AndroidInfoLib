package com.udfsoft.androidinfo.lib.entity

import com.udfsoft.androidinfo.lib.command.entity.general.LocalGeneralInformation
import com.udfsoft.androidinfo.lib.command.entity.general.NetworkGeneralInformation

data class GeneralInformation(
    val realBrand: String,
    val realModel: String,
    val brand: String?,
    val model: String?,
    val modelAlias: String?
) {

    constructor(
        localGeneralInformation: LocalGeneralInformation,
        networkGeneralInformation: NetworkGeneralInformation
    ) : this(
        localGeneralInformation.brand,
        localGeneralInformation.model,
        networkGeneralInformation.brand,
        networkGeneralInformation.model,
        networkGeneralInformation.modelAlias
    )
}
