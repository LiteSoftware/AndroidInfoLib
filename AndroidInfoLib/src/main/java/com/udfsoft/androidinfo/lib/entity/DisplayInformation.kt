package com.udfsoft.androidinfo.lib.entity

import android.util.Size

data class DisplayInformation(
    val screenSize: Size?,
    val screenSizeCategory: String?,
    val rotation: Int?,
    val isHdr: Boolean?,
    val screenRefreshRate: Float?,
    val displayId: Int?,
    val displayName: String?,
    val appVsyncOffsetNanos: Long?,
    val type: String?,
    val diagonalSize: String?,
    val width: String?,
    val height: String?,
    val aspectRatio: String?,
    val resolution: String?,
    val pixelDensity: String?,
    val colorDepth: String?,
    val displayArea: String?,
    val otherFeatures: String?
)
