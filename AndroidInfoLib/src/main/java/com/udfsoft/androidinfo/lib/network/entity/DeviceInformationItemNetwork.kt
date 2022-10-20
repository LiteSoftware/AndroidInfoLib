package com.udfsoft.androidinfo.lib.network.entity

import com.google.gson.annotations.SerializedName

data class DeviceInformationItemNetwork(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val key: String? = null,
    @SerializedName("value") val value: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("visible") val visible: Boolean = false,
    @SerializedName("type") val type: Int = 1
)
