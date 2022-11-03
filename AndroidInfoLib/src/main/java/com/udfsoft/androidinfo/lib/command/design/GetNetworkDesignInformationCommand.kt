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

package com.udfsoft.androidinfo.lib.command.design

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.design.DesignIds
import com.udfsoft.androidinfo.lib.command.entity.design.MutableDesignInformation
import com.udfsoft.androidinfo.lib.entity.DesignInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetNetworkDesignInformationCommand(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, DesignInformation> {

    override fun invoke(param: Unit): DesignInformation {
        val mutableEntity = MutableDesignInformation()
        val deviceInformation = api.getDeviceInfo(MenuIds.MENU_ID_DESIGN.menuId).execute().body()
        deviceInformation?.deviceMenuItemList?.forEach {
            when (it.id) {
                DesignIds.Width.id -> mutableEntity.width = it.value
                DesignIds.Height.id -> mutableEntity.height = it.value
                DesignIds.Weight.id -> mutableEntity.weight = it.value
                DesignIds.Colors.id -> mutableEntity.colors = it.value
                DesignIds.Volume.id -> mutableEntity.volume = it.value
                DesignIds.BodyMaterials.id -> mutableEntity.bodyMaterials = it.value
            }
        }
        return DesignInformation(mutableEntity)
    }
}