package com.udfsoft.androidinfo.lib.command.entity.camera

import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.entity.RearCameraInformation

data class MutableRearCameraInformation(
    var sensorModel: String? = null,
    var sensorFormat: String? = null,
    var pixelSize: String? = null,
    var aperture: String? = null,
    var focalLength: String? = null,
    var flashType: String? = null,
    var imageResolution: String? = null,
    var videoResolution: String? = null,
    var videoFPS: String? = null,
    var features: String? = null
) : MutableEntity<RearCameraInformation> {

    override fun build() = RearCameraInformation(
        sensorModel,
        sensorFormat,
        pixelSize,
        aperture,
        focalLength,
        flashType,
        imageResolution,
        videoResolution,
        videoFPS,
        features
    )
}
