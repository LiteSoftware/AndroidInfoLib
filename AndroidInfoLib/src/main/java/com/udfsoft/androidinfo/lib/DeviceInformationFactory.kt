package com.udfsoft.androidinfo.lib

import android.os.Build
import com.udfsoft.androidinfo.lib.entity.*

object DeviceInformationFactory : DeviceInformation {

    override fun getGeneralInformation() = GeneralInformation(Build.BRAND, Build.MODEL)

    override fun getDesignInformation(): DesignInformation {
        TODO("Not yet implemented")
    }

    override fun getSIMCardInformation(): SIMCardInformation {
        TODO("Not yet implemented")
    }

    override fun getNetworkInformation(): NetworkInformation {
        TODO("Not yet implemented")
    }

    override fun getNetworkTechnologiesInformation(): NetworkTechnologiesInformation {
        TODO("Not yet implemented")
    }

    override fun getOSInformation(): OSInformation {
        TODO("Not yet implemented")
    }

    override fun getCPUInformation(): CPUInformation {
        TODO("Not yet implemented")
    }

    override fun getGPUInformation(): GPUInformation {
        TODO("Not yet implemented")
    }

    override fun getRAMInformation(): RAMInformation {
        TODO("Not yet implemented")
    }

    override fun getStorageInformation(): StorageInformation {
        TODO("Not yet implemented")
    }

    override fun getDisplayInformation(): DisplayInformation {
        TODO("Not yet implemented")
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