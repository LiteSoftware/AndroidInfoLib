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

    fun getNetworkTechnologiesInformation(context: Context): NetworkTechnologiesInformation

    fun getOSInformation(): OSInformation

    fun getCPUInformation(): CPUInformation

    fun getGPUInformation(): GPUInformation

    fun getRAMInformation(context: Context): RAMInformation

    fun getStorageInformation(): StorageInformation

    fun getDisplayInformation(context: Context): DisplayInformation

    fun getSensorsInformation(): SensorsInformation

    fun getRearCameraInformation(): RearCameraInformation

    fun getFrontCameraInformation(): FrontCameraInformation

    fun getAudioInformation(): AudioInformation

    fun getWirelessInformation(): WirelessInformation

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