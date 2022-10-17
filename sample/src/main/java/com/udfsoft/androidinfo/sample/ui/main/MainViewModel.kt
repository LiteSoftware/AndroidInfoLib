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

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, "android.permission.READ_PHONE_NUMBERS"]
    )
    fun loadInformation(context: Context) = viewModelScope.launch(Dispatchers.IO) {
        generalInformationLiveData.postValue(DeviceInformationFactory.getGeneralInformation())
        ramInformationLiveData.postValue(DeviceInformationFactory.getRAMInformation(context))
        osInformationLiveData.postValue(DeviceInformationFactory.getOSInformation())
        cpuInformationLiveData.postValue(DeviceInformationFactory.getCPUInformation())
        simCardInformationLiveData.postValue(DeviceInformationFactory.getSIMCardInformation(context))
    }

    fun getGeneralInformationLiveData() = generalInformationLiveData.toLiveData()

    fun getRAMInformationLiveData() = ramInformationLiveData.toLiveData()

    fun getOSInformationLiveData() = osInformationLiveData.toLiveData()

    fun getCPUInformationLiveData() = cpuInformationLiveData.toLiveData()

    fun getSIMCardInformationLiveData() = simCardInformationLiveData.toLiveData()
}