package com.udfsoft.androidinfo.lib.entity

import android.util.Size

data class DisplayInformation(
    val screenSize: Size,
    val screenSizeCategory: String,
    val rotation: Int?,
    val isHdr: Boolean?,
    val screenRefreshRate: Float?,
    val displayId: Int?,
    val displayName: String?,
    val appVsyncOffsetNanos: Long?
)
