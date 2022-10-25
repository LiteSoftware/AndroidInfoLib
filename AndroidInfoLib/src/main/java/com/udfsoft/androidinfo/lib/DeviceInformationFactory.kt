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
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.annotation.WorkerThread
import com.udfsoft.androidinfo.lib.command.GetRAMInformationCommand
import com.udfsoft.androidinfo.lib.command.cpu.GetCpuInformationCommand
import com.udfsoft.androidinfo.lib.command.design.GetNetworkDesignInformationCommand
import com.udfsoft.androidinfo.lib.command.display.GetDisplayInformationCommand
import com.udfsoft.androidinfo.lib.command.general.GetGeneralInformationCommand
import com.udfsoft.androidinfo.lib.command.gpu.GetGPUInformationCommand
import com.udfsoft.androidinfo.lib.command.network.GetNetworkTechnologiesInformationCommand
import com.udfsoft.androidinfo.lib.command.os.GetOSInformationCommand
import com.udfsoft.androidinfo.lib.command.sim.GetSIMCardInformationCommand
import com.udfsoft.androidinfo.lib.command.storage.GetStorageInformation
import com.udfsoft.androidinfo.lib.di.NetworkFactory
import com.udfsoft.androidinfo.lib.entity.*

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

    override fun getDisplayInformation(context: Context): DisplayInformation {
        val getDisplayInformationCommand = GetDisplayInformationCommand(context)
        return getDisplayInformationCommand(Unit)
    }

    override fun getSensorsInformation(): SensorsInformation {
        TODO("Not yet implemented")
    }

    override fun getRearCameraInformation(): RearCameraInformation {
        TODO("Not yet implemented")
    }

    override fun getFrontCameraInformation(): FrontCameraInformation {
        TODO("Not yet implemented")
    }

    override fun getAudioInformation(): AudioInformation {
        TODO("Not yet implemented")
    }

    override fun getRadioInformation(): RadioInformation {
        TODO("Not yet implemented")
    }

    override fun getTrackingInformation(): TrackingInformation {
        TODO("Not yet implemented")
    }

    override fun getWIFIInformation(): WIFIInformation {
        TODO("Not yet implemented")
    }

    override fun getBluetoothInformation(): BluetoothInformation {
        TODO("Not yet implemented")
    }

    override fun getUSBInformation(): USBInformation {
        TODO("Not yet implemented")
    }

    override fun getHeadphoneJackInformation(): HeadphoneJackInformation {
        TODO("Not yet implemented")
    }

    override fun getConnectivityInformation(): ConnectivityInformation {
        TODO("Not yet implemented")
    }

    override fun getBrowserInformation(): BrowserInformation {
        TODO("Not yet implemented")
    }

    override fun getAudioCodecsInformation(): AudioCodecsInformation {
        TODO("Not yet implemented")
    }

    override fun getVideoCodecsInformation(): VideoCodecsInformation {
        TODO("Not yet implemented")
    }

    override fun getBatteryInformation(): BatteryInformation {
        TODO("Not yet implemented")
    }

    override fun getAdditionalFeaturesInformation(): AdditionalFeaturesInformation {
        TODO("Not yet implemented")
    }
}