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

package com.udfsoft.androidinfo.lib.command.gpu

import com.udfsoft.androidinfo.lib.command.BaseGetCloudInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.gpu.GPUIds
import com.udfsoft.androidinfo.lib.command.entity.gpu.MutableGPUInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationItemNetwork

class GetCloudGPUInformation(
    val api: AndroidInfoApi
) : BaseGetCloudInformationCommand<MutableGPUInformation>(api, MenuIds.MENU_ID_GPU) {

    override fun processInfo(
        item: DeviceInformationItemNetwork,
        entity: MutableGPUInformation
    ) {
        when (item.id) {
            GPUIds.GPUName.id -> entity.name = item.value
        }
    }
}