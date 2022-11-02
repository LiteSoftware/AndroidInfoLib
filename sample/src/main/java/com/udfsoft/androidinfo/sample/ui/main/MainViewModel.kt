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

import androidx.lifecycle.ViewModel
import com.udfsoft.androidinfo.sample.core.entity.MenuItem
import com.udfsoft.androidinfo.sample.core.entity.MenuItemEnum
import com.udfsoft.androidinfo.sample.util.listLiveData
import com.udfsoft.androidinfo.sample.util.toLiveData

class MainViewModel : ViewModel() {

    private val menuLiveData = listLiveData<MenuItem>()

    fun loadMenu() {
        menuLiveData.value = MenuItemEnum.values()
            .map {
                MenuItem(it.ordinal, it.title, it.logoId)
            }
    }

    fun getMenuLiveData() = menuLiveData.toLiveData()
}