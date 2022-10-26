/*
 * Copyright 2022 Javavirys
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

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
