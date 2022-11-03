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

package com.udfsoft.androidinfo.lib.command.entity.camera

enum class FrontCameraIds(val id: Int) {
    SensorModel(13600),
    SensorType(13610),
    Aperture(13620),
    FocalLength(13630),
    ImageResolution(13640),
    VideoResolution(13650),
    VideoFPS(13660),
    Features(13670)
}