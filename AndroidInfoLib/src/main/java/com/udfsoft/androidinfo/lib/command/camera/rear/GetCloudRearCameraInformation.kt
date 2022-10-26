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

package com.udfsoft.androidinfo.lib.command.camera.rear

import com.udfsoft.androidinfo.lib.command.BaseGetCloudInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.camera.CameraIds
import com.udfsoft.androidinfo.lib.command.entity.camera.MutableRearCameraInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationItemNetwork

class GetCloudRearCameraInformation(
    val api: AndroidInfoApi
) : BaseGetCloudInformationCommand<MutableRearCameraInformation>(api, MenuIds.MENU_ID_REAR_CAMERA) {

    override fun processInfo(
        item: DeviceInformationItemNetwork, entity: MutableRearCameraInformation
    ) {
        when (item.id) {
            CameraIds.SensorModel.id -> entity.sensorModel = item.value
            CameraIds.SensorFormat.id -> entity.sensorFormat = item.value
            CameraIds.PixelSize.id -> entity.pixelSize = item.value
            CameraIds.Aperture.id -> entity.aperture = item.value
            CameraIds.FocalLength.id -> entity.focalLength = item.value
            CameraIds.FlashType.id -> entity.flashType = item.value
            CameraIds.ImageResolution.id -> entity.imageResolution = item.value
            CameraIds.VideoResolution.id -> entity.videoResolution = item.value
            CameraIds.VideoFPS.id -> entity.videoFPS = item.value
            CameraIds.Features.id -> entity.features = item.value
        }
    }
}