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

package com.udfsoft.androidinfo.lib.command.general

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.general.GeneralIds
import com.udfsoft.androidinfo.lib.command.entity.general.NetworkGeneralInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetNetworkGeneralInformationCommand(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, NetworkGeneralInformation> {

    override fun invoke(param: Unit): NetworkGeneralInformation {
        var brand: String? = null
        var model: String? = null
        var modelAlias: String? = null
        val deviceInformation = api.getDeviceInfo(MenuIds.MENU_ID_GENERAL.menuId).execute().body()
        deviceInformation?.deviceMenuItemList?.forEach {
            when (it.id) {
                GeneralIds.BRAND.id -> brand = it.value
                GeneralIds.MODEL.id -> model = it.value
                GeneralIds.MODEL_ALIAS.id -> modelAlias = it.value
            }
        }
        return NetworkGeneralInformation(brand, model, modelAlias)
    }
}