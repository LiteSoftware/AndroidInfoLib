package com.udfsoft.androidinfo.lib.entity

import com.udfsoft.androidinfo.lib.command.entity.design.MutableDesignInformation

data class DesignInformation(
    val width: String?,
    val height: String?,
    val weight: String?,
    val volume: String?,
    val colors: String?,
    val bodyMaterials: String?
) {

    constructor(mutableEntity: MutableDesignInformation) : this(
        mutableEntity.width,
        mutableEntity.height,
        mutableEntity.weight,
        mutableEntity.volume,
        mutableEntity.colors,
        mutableEntity.bodyMaterials
    )
}
