package com.udfsoft.androidinfo.lib.command.entity.camera

import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.entity.FrontCameraInformation

data class MutableFrontCameraInformation(
    var sensorModel: String? = null,
    var sensorType: String? = null,
    var aperture: String? = null,
    var focalLength: String? = null,
    var imageResolution: String? = null,
    var videoResolution: String? = null,
    var videoFPS: String? = null,
    var features: String? = null
) : MutableEntity<FrontCameraInformation> {

    override fun build() = FrontCameraInformation(
        sensorModel,
        sensorType,
        aperture,
        focalLength,
        imageResolution,
        videoResolution,
        videoFPS,
        features
    )
}
