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

package com.udfsoft.androidinfo.lib.command.wireless

import com.udfsoft.androidinfo.lib.command.BaseGetCloudInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.entity.wireless.MutableWirelessInformation
import com.udfsoft.androidinfo.lib.command.entity.wireless.WirelessIds
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationItemNetwork

class GetCloudWirelessInformationCommand(
    val api: AndroidInfoApi
) : BaseGetCloudInformationCommand<MutableWirelessInformation>(
    api,
    MenuIds.MENU_ID_WIRELESS
) {

    override fun processInfo(
        item: DeviceInformationItemNetwork,
        entity: MutableWirelessInformation
    ) {
        when (item.id) {
            WirelessIds.Radio.id -> entity.radio = item.value
            WirelessIds.TrackingPositioning.id -> entity.trackingPositioning = item.value
            WirelessIds.WiFi.id -> entity.wifi = item.value
            WirelessIds.BluetoothVersion.id -> entity.bluetoothVersion = item.value
            WirelessIds.BluetoothFeatures.id -> entity.bluetoothFeatures = item.value
        }
    }
}