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

package com.udfsoft.androidinfo.sample.ui.details

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udfsoft.androidinfo.lib.DeviceInformationFactory
import com.udfsoft.androidinfo.lib.entity.*
import com.udfsoft.androidinfo.sample.util.toLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private val progressLiveData = MutableLiveData<Boolean>()

    private val informationLiveData = MutableLiveData<Map<String, Any?>>()

    private val generalInformationLiveData = MutableLiveData<GeneralInformation>()

    private val ramInformationLiveData = MutableLiveData<RAMInformation>()

    private val osInformationLiveData = MutableLiveData<OSInformation>()

    private val cpuInformationLiveData = MutableLiveData<CPUInformation>()

    private val simCardInformationLiveData = MutableLiveData<SIMCardInformation>()

    private val displayInformationLiveData = MutableLiveData<DisplayInformation>()

    private val networkTechnologiesInformationLiveData =
        MutableLiveData<NetworkTechnologiesInformation>()

    private val designInformationLiveData = MutableLiveData<DesignInformation>()

    private val storageInformationLiveData = MutableLiveData<StorageInformation>()

    private val gpuInformationLiveData = MutableLiveData<GPUInformation>()

    private val sensorsInformationLiveData = MutableLiveData<SensorsInformation>()

    private val rearCameraInformationLiveData = MutableLiveData<RearCameraInformation>()

    private val frontCameraInformationLiveData = MutableLiveData<FrontCameraInformation>()

    private val audioInformationLiveData = MutableLiveData<AudioInformation>()

    private val wirelessInformationLiveData = MutableLiveData<WirelessInformation>()

    private val usbInformationLiveData = MutableLiveData<USBInformation>()

    private val browserInformationLiveData = MutableLiveData<BrowserInformation>()

    private val codecsInformationLiveData = MutableLiveData<CodecsInformation>()

    private val batteryInformationLiveData = MutableLiveData<BatteryInformation>()

    private val sarInformationLiveData = MutableLiveData<SARInformation>()

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, "android.permission.READ_PHONE_NUMBERS"]
    )
    fun loadInformation(context: Context, menuId: Int) = viewModelScope.launch(Dispatchers.IO) {
        progressLiveData.postValue(true)

//        val information = when (menuId) {
//            MenuItemEnum.General.ordinal -> DeviceInformationFactory.getGeneralInformation().asMap()
//            MenuItemEnum.Design.ordinal -> DeviceInformationFactory.getDesignInformation().asMap()
//            MenuItemEnum.SIMCard.ordinal ->
//                DeviceInformationFactory.getSIMCardInformation(context).asMap()
//            MenuItemEnum.RAM.ordinal -> DeviceInformationFactory.getRAMInformation(context).asMap()
//            else -> emptyMap()
//        }

        val information = DeviceInformationFactory.getInfoById(menuId, context)

        informationLiveData.postValue(information)
        progressLiveData.postValue(false)
//        generalInformationLiveData.postValue(DeviceInformationFactory.getGeneralInformation())
//        ramInformationLiveData.postValue(DeviceInformationFactory.getRAMInformation(context))
//        osInformationLiveData.postValue(DeviceInformationFactory.getOSInformation())
//        cpuInformationLiveData.postValue(DeviceInformationFactory.getCPUInformation())
//        simCardInformationLiveData.postValue(DeviceInformationFactory.getSIMCardInformation(context))
//        displayInformationLiveData.postValue(DeviceInformationFactory.getDisplayInformation(context))
//        networkTechnologiesInformationLiveData.postValue(
//            DeviceInformationFactory.getNetworkTechnologiesInformation(
//                context
//            )
//        )
//        designInformationLiveData.postValue(DeviceInformationFactory.getDesignInformation())
//        storageInformationLiveData.postValue(DeviceInformationFactory.getStorageInformation())
//        gpuInformationLiveData.postValue(DeviceInformationFactory.getGPUInformation())
//        sensorsInformationLiveData.postValue(DeviceInformationFactory.getSensorsInformation())
//        rearCameraInformationLiveData.postValue(DeviceInformationFactory.getRearCameraInformation())
//        frontCameraInformationLiveData.postValue(DeviceInformationFactory.getFrontCameraInformation())
//        audioInformationLiveData.postValue(DeviceInformationFactory.getAudioInformation())
//        wirelessInformationLiveData.postValue(DeviceInformationFactory.getWirelessInformation())
//        usbInformationLiveData.postValue(DeviceInformationFactory.getUSBInformation())
//        browserInformationLiveData.postValue(DeviceInformationFactory.getBrowserInformation())
//        codecsInformationLiveData.postValue(DeviceInformationFactory.getCodecsInformation())
//        batteryInformationLiveData.postValue(DeviceInformationFactory.getBatteryInformation())
//        sarInformationLiveData.postValue(DeviceInformationFactory.getSARInformation())
    }

    fun getGeneralInformationLiveData() = generalInformationLiveData.toLiveData()

    fun getRAMInformationLiveData() = ramInformationLiveData.toLiveData()

    fun getOSInformationLiveData() = osInformationLiveData.toLiveData()

    fun getCPUInformationLiveData() = cpuInformationLiveData.toLiveData()

    fun getSIMCardInformationLiveData() = simCardInformationLiveData.toLiveData()

    fun getDisplayInformationLiveData() = displayInformationLiveData.toLiveData()

    fun getNetworkTechnologiesInformationLiveData() =
        networkTechnologiesInformationLiveData.toLiveData()

    fun getDesignInformationLiveData() = designInformationLiveData.toLiveData()

    fun getStorageInformationLiveData() = storageInformationLiveData.toLiveData()

    fun getGPUInformationLiveData() = gpuInformationLiveData.toLiveData()

    fun getSensorsInformationLiveData() = sensorsInformationLiveData.toLiveData()

    fun getRearCameraInformationLiveData() = rearCameraInformationLiveData.toLiveData()

    fun getFrontCameraInformationLiveData() = frontCameraInformationLiveData.toLiveData()

    fun getAudioInformationLiveData() = audioInformationLiveData.toLiveData()

    fun getWirelessInformationLiveData() = wirelessInformationLiveData.toLiveData()

    fun getUSBInformationLiveData() = usbInformationLiveData.toLiveData()

    fun getBrowserInformationLiveData() = browserInformationLiveData.toLiveData()

    fun getCodecsInformationLiveData() = codecsInformationLiveData.toLiveData()

    fun getBatteryInformationLiveData() = batteryInformationLiveData.toLiveData()

    fun getSARInformationLiveData() = sarInformationLiveData.toLiveData()

    fun getInformationLiveData() = informationLiveData.toLiveData()

    fun getProgressLiveData() = progressLiveData.toLiveData()
}