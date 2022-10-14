package com.udfsoft.androidinfo.sample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udfsoft.androidinfo.lib.DeviceInformationFactory
import com.udfsoft.androidinfo.lib.entity.GeneralInformation
import com.udfsoft.androidinfo.lib.entity.OSInformation
import com.udfsoft.androidinfo.sample.util.toLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val generalInformationLiveData = MutableLiveData<GeneralInformation>()

    private val osInformationLiveData = MutableLiveData<OSInformation>()

    fun loadInformation() = viewModelScope.launch(Dispatchers.IO) {
        generalInformationLiveData.postValue(DeviceInformationFactory.getGeneralInformation())
        osInformationLiveData.postValue(DeviceInformationFactory.getOSInformation())
    }

    fun getGeneralInformationLiveData() = generalInformationLiveData.toLiveData()

    fun getOSInformationLiveData() = osInformationLiveData.toLiveData()
}