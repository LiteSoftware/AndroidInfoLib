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

package com.udfsoft.androidinfo.lib.command.display

import com.udfsoft.androidinfo.lib.command.BaseGetCloudInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.display.DisplayIds
import com.udfsoft.androidinfo.lib.command.entity.display.MutableDisplayInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationItemNetwork

class GetCloudDisplayInformation(
    val api: AndroidInfoApi
) : BaseGetCloudInformationCommand<MutableDisplayInformation>(api, MenuIds.MENU_ID_DISPLAY) {

    override fun processInfo(
        item: DeviceInformationItemNetwork,
        entity: MutableDisplayInformation
    ) {
        when (item.id) {
            DisplayIds.TypeTechnology.id -> entity.type = item.value
            DisplayIds.DiagonalSize.id -> entity.diagonalSize = item.value
            DisplayIds.Width.id -> entity.width = item.value
            DisplayIds.Height.id -> entity.height = item.value
            DisplayIds.AspectRatio.id -> entity.aspectRatio = item.value
            DisplayIds.Resolution.id -> entity.resolution = item.value
            DisplayIds.PixelDensity.id -> entity.pixelDensity = item.value
            DisplayIds.ColorDepth.id -> entity.colorDepth = item.value
            DisplayIds.DisplayArea.id -> entity.displayArea = item.value
            DisplayIds.OtherFeatures.id -> entity.otherFeatures = item.value
        }
    }
}