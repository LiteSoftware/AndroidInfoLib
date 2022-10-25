package com.udfsoft.androidinfo.lib.command.entity.display

import android.util.Size
import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.entity.DisplayInformation

data class MutableDisplayInformation(
    var screenSize: Size? = null,
    var screenSizeCategory: String? = null,
    var rotation: Int? = null,
    var isHdr: Boolean? = null,
    var screenRefreshRate: Float? = null,
    var displayId: Int? = null,
    var displayName: String? = null,
    var appVsyncOffsetNanos: Long? = null,
    var type: String? = null,
    var diagonalSize: String? = null,
    var width: String? = null,
    var height: String? = null,
    var aspectRatio: String? = null,
    var resolution: String? = null,
    var pixelDensity: String? = null,
    var colorDepth: String? = null,
    var displayArea: String? = null,
    var otherFeatures: String? = null
) : MutableEntity<DisplayInformation> {

    override fun build() = DisplayInformation(
        screenSize,
        screenSizeCategory,
        rotation,
        isHdr,
        screenRefreshRate,
        displayId,
        displayName,
        appVsyncOffsetNanos,
        type,
        diagonalSize,
        width,
        height,
        aspectRatio,
        resolution,
        pixelDensity,
        colorDepth,
        displayArea,
        otherFeatures
    )
}
