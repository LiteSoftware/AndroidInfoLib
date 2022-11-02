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
import com.udfsoft.androidinfo.sample.util.toLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private val progressLiveData = MutableLiveData<Boolean>()

    private val informationLiveData = MutableLiveData<Map<String, Any?>>()

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, "android.permission.READ_PHONE_NUMBERS"]
    )
    fun loadInformation(context: Context, menuId: Int) = viewModelScope.launch(Dispatchers.IO) {
        progressLiveData.postValue(true)
        informationLiveData.postValue(DeviceInformationFactory.getInfoById(menuId, context))
        progressLiveData.postValue(false)
    }

    fun getInformationLiveData() = informationLiveData.toLiveData()

    fun getProgressLiveData() = progressLiveData.toLiveData()
}