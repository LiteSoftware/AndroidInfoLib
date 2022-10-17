package com.udfsoft.androidinfo.lib

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.annotation.WorkerThread
import com.udfsoft.androidinfo.lib.entity.*

@WorkerThread
interface DeviceInformation {

    fun getGeneralInformation(): GeneralInformation

    fun getDesignInformation(): DesignInformation

    @RequiresPermission(
        allOf = [
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_SMS,
            "android.permission.READ_PHONE_NUMBERS"
        ]
    )
    fun getSIMCardInformation(context: Context): SIMCardInformation

    fun getNetworkInformation(): NetworkInformation

    fun getNetworkTechnologiesInformation(): NetworkTechnologiesInformation

    fun getOSInformation(): OSInformation

    fun getCPUInformation(): CPUInformation

    fun getGPUInformation(): GPUInformation

    fun getRAMInformation(context: Context): RAMInformation

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