package com.udfsoft.androidinfo.lib.network.entity

import com.google.gson.annotations.SerializedName

data class DeviceInformationNetwork(
    @SerializedName("deviceInformation") val deviceMenuItemList: List<DeviceInformationItemNetwork>
)
