package com.udfsoft.androidinfo.sample.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udfsoft.androidinfo.lib.DeviceInformationFactory
import com.udfsoft.androidinfo.lib.entity.CPUInformation
import com.udfsoft.androidinfo.lib.entity.GeneralInformation
import com.udfsoft.androidinfo.lib.entity.RAMInformation
import com.udfsoft.androidinfo.lib.entity.OSInformation
import com.udfsoft.androidinfo.sample.util.toLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val generalInformationLiveData = MutableLiveData<GeneralInformation>()

    private val ramInformationLiveData = MutableLiveData<RAMInformation>()

    private val osInformationLiveData = MutableLiveData<OSInformation>()

    private val cpuInformationLiveData = MutableLiveData<CPUInformation>()

    fun loadInformation(context: Context) = viewModelScope.launch(Dispatchers.IO) {
        generalInformationLiveData.postValue(DeviceInformationFactory.getGeneralInformation())
        ramInformationLiveData.postValue(DeviceInformationFactory.getRAMInformation(context))
        osInformationLiveData.postValue(DeviceInformationFactory.getOSInformation())
        cpuInformationLiveData.postValue(DeviceInformationFactory.getCPUInformation())
    }

    fun getGeneralInformationLiveData() = generalInformationLiveData.toLiveData()

    fun getRAMInformationLiveData() = ramInformationLiveData.toLiveData()

    fun getOSInformationLiveData() = osInformationLiveData.toLiveData()

    fun getCPUInformationLiveData() = cpuInformationLiveData.toLiveData()
}