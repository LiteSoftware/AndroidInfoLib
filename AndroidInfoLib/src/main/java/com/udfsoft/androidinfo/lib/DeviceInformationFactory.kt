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

package com.udfsoft.androidinfo.lib

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.annotation.WorkerThread
import com.udfsoft.androidinfo.lib.command.GetRAMInformationCommand
import com.udfsoft.androidinfo.lib.command.audio.GetAudioInformationCommand
import com.udfsoft.androidinfo.lib.command.battery.GetBatteryInformationCommand
import com.udfsoft.androidinfo.lib.command.browser.GetBrowserInformationCommand
import com.udfsoft.androidinfo.lib.command.camera.front.GetFrontCameraInformationCommand
import com.udfsoft.androidinfo.lib.command.camera.rear.GetRearCameraInformationCommand
import com.udfsoft.androidinfo.lib.command.codecs.GetCodecsInformationCommand
import com.udfsoft.androidinfo.lib.command.cpu.GetCpuInformationCommand
import com.udfsoft.androidinfo.lib.command.design.GetNetworkDesignInformationCommand
import com.udfsoft.androidinfo.lib.command.display.GetDisplayInformationCommand
import com.udfsoft.androidinfo.lib.command.entity.MenuIds
import com.udfsoft.androidinfo.lib.command.general.GetGeneralInformationCommand
import com.udfsoft.androidinfo.lib.command.gpu.GetGPUInformationCommand
import com.udfsoft.androidinfo.lib.command.network.GetNetworkTechnologiesInformationCommand
import com.udfsoft.androidinfo.lib.command.os.GetOSInformationCommand
import com.udfsoft.androidinfo.lib.command.sar.GetSARInformationCommand
import com.udfsoft.androidinfo.lib.command.sensors.GetSensorsInformationCommand
import com.udfsoft.androidinfo.lib.command.sim.GetSIMCardInformationCommand
import com.udfsoft.androidinfo.lib.command.storage.GetStorageInformation
import com.udfsoft.androidinfo.lib.command.usb.GetUSBInformationCommand
import com.udfsoft.androidinfo.lib.command.wireless.GetWirelessInformationCommand
import com.udfsoft.androidinfo.lib.di.NetworkFactory
import com.udfsoft.androidinfo.lib.entity.CPUInformation
import com.udfsoft.androidinfo.lib.entity.OSInformation
import com.udfsoft.androidinfo.lib.entity.RAMInformation
import com.udfsoft.androidinfo.lib.util.asMap

@WorkerThread
object DeviceInformationFactory : DeviceInformation {

    private const val LOG_TAG = "DeviceInformation"

    private val api by lazy { NetworkFactory.getAndroidInfoApi() }

    override fun getGeneralInformation() = GetGeneralInformationCommand(api).invoke(Unit)

    override fun getDesignInformation() = GetNetworkDesignInformationCommand(api).invoke(Unit)

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, "android.permission.READ_PHONE_NUMBERS"]
    )
    override fun getSIMCardInformation(context: Context) =
        GetSIMCardInformationCommand(context, api).invoke(Unit)

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    override fun getNetworkTechnologiesInformation(context: Context) =
        GetNetworkTechnologiesInformationCommand(context, api).invoke(Unit)

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    override fun getOSInformation(): OSInformation {
        val getOSInformationCommand = GetOSInformationCommand(api)
        return getOSInformationCommand(Unit)
    }

    override fun getCPUInformation(): CPUInformation {
        val getCpuInformationCommand = GetCpuInformationCommand()
        return getCpuInformationCommand(Unit)
    }

    override fun getGPUInformation() = GetGPUInformationCommand(api).invoke(Unit)

    override fun getRAMInformation(context: Context): RAMInformation {
        val getRAMInformationCommand = GetRAMInformationCommand(context)
        return getRAMInformationCommand(Unit)
    }

    override fun getStorageInformation() = GetStorageInformation(api).invoke(Unit)

    override fun getDisplayInformation(context: Context) =
        GetDisplayInformationCommand(context, api).invoke(Unit)

    override fun getSensorsInformation() = GetSensorsInformationCommand(api).invoke(Unit)

    override fun getRearCameraInformation() = GetRearCameraInformationCommand(api).invoke(Unit)

    override fun getFrontCameraInformation() = GetFrontCameraInformationCommand(api).invoke(Unit)

    override fun getAudioInformation() = GetAudioInformationCommand(api).invoke(Unit)

    override fun getWirelessInformation() = GetWirelessInformationCommand(api).invoke(Unit)

    override fun getUSBInformation() = GetUSBInformationCommand(api).invoke(Unit)

    override fun getBrowserInformation() = GetBrowserInformationCommand(api).invoke(Unit)

    override fun getCodecsInformation() = GetCodecsInformationCommand(api).invoke(Unit)

    override fun getBatteryInformation() = GetBatteryInformationCommand(api).invoke(Unit)

    override fun getSARInformation() = GetSARInformationCommand(api).invoke(Unit)

    @SuppressLint("MissingPermission")
    override fun getInfoById(id: Int, context: Context): Map<String, Any?> =
        when (MenuIds.findMenuIdByIndex(id)) {
            MenuIds.MENU_ID_GENERAL -> getGeneralInformation().asMap()
            MenuIds.MENU_ID_DESIGN -> getDesignInformation().asMap()
            MenuIds.MENU_ID_SIM -> getSIMCardInformation(context).asMap()
            MenuIds.MENU_ID_MOBILE_NETWORK -> getNetworkTechnologiesInformation(context).asMap()
            MenuIds.MENU_ID_OS -> getOSInformation().asMap()
            MenuIds.MENU_ID_PROCESSOR -> getCPUInformation().asMap()
            MenuIds.MENU_ID_GPU -> getGPUInformation().asMap()
            MenuIds.MENU_ID_MEMORY -> getRAMInformation(context).asMap()
            MenuIds.MENU_ID_STORAGE -> getStorageInformation().asMap()
            MenuIds.MENU_ID_DISPLAY -> getDisplayInformation(context).asMap()
            MenuIds.MENU_ID_SENSORS -> getSensorsInformation().asMap()
            MenuIds.MENU_ID_REAR_CAMERA -> getRearCameraInformation().asMap()
            MenuIds.MENU_ID_FRONT_CAMERA -> getFrontCameraInformation().asMap()
            MenuIds.MENU_ID_AUDIO -> getAudioInformation().asMap()
            MenuIds.MENU_ID_WIRELESS -> getWirelessInformation().asMap()
            MenuIds.MENU_ID_USB -> getUSBInformation().asMap()
            MenuIds.MENU_ID_BROWSER -> getBrowserInformation().asMap()
            MenuIds.MENU_ID_CODECS -> getCodecsInformation().asMap()
            MenuIds.MENU_ID_BATTERY -> getBatteryInformation().asMap()
            MenuIds.MENU_ID_SAR -> getSARInformation().asMap()
            else -> throw UnsupportedOperationException()
        }
}