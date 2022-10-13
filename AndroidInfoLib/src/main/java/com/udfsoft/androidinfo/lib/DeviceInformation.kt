package com.udfsoft.androidinfo.lib

import com.udfsoft.androidinfo.lib.entity.*

interface DeviceInformation {

    fun getGeneralInformation(): GeneralInformation

    fun getDesignInformation() : DesignInformation

    fun getSIMCardInformation(): SIMCardInformation

    fun getNetworkInformation(): NetworkInformation

    fun getNetworkTechnologiesInformation(): NetworkTechnologiesInformation

    fun getOSInformation(): OSInformation

    fun getCPUInformation(): CPUInformation

    fun getGPUInformation(): GPUInformation

    fun getRAMInformation(): RAMInformation

    fun getStorageInformation(): StorageInformation

    fun getDisplayInformation(): DisplayInformation

    fun getSensorsInformation(): SensorsInformation

    fun getRearCameraInformation(): RearCameraInformation

    fun getFrontCameraInformation(): FrontCameraInformation

    fun getAudioInformation(): AudioInformation

    fun getRadioInformation(): RadioInformation

    fun getTrackingInformation(): TrackingInformation

    fun getWIFIInformation(): WIFIInformation

    fun getBluetoothInformation(): BluetoothInformation

    fun getUSBInformation(): USBInformation

    fun getHeadphoneJackInformation(): HeadphoneJackInformation

    fun getConnectivityInformation(): ConnectivityInformation

    fun getBrowserInformation(): BrowserInformation

    fun getAudioCodecsInformation(): AudioCodecsInformation

    fun getVideoCodecsInformation(): VideoCodecsInformation

    fun getBatteryInformation(): BatteryInformation

    fun getAdditionalFeaturesInformation(): AdditionalFeaturesInformation
}