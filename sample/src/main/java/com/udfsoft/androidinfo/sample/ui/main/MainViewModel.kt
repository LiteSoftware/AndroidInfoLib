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

package com.udfsoft.androidinfo.sample.ui.main

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

class MainViewModel : ViewModel() {

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

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, "android.permission.READ_PHONE_NUMBERS"]
    )
    fun loadInformation(context: Context) = viewModelScope.launch(Dispatchers.IO) {
        generalInformationLiveData.postValue(DeviceInformationFactory.getGeneralInformation())
        ramInformationLiveData.postValue(DeviceInformationFactory.getRAMInformation(context))
        osInformationLiveData.postValue(DeviceInformationFactory.getOSInformation())
        cpuInformationLiveData.postValue(DeviceInformationFactory.getCPUInformation())
        simCardInformationLiveData.postValue(DeviceInformationFactory.getSIMCardInformation(context))
        displayInformationLiveData.postValue(DeviceInformationFactory.getDisplayInformation(context))
        networkTechnologiesInformationLiveData.postValue(
            DeviceInformationFactory.getNetworkTechnologiesInformation(
                context
            )
        )
        designInformationLiveData.postValue(DeviceInformationFactory.getDesignInformation())
        storageInformationLiveData.postValue(DeviceInformationFactory.getStorageInformation())
        gpuInformationLiveData.postValue(DeviceInformationFactory.getGPUInformation())
        sensorsInformationLiveData.postValue(DeviceInformationFactory.getSensorsInformation())
        rearCameraInformationLiveData.postValue(DeviceInformationFactory.getRearCameraInformation())
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
}