package com.udfsoft.androidinfo.lib.network

import com.udfsoft.androidinfo.lib.network.entity.DeviceInformationNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface AndroidInfoApi {

    @GET("GetDeviceInfo/")
    fun getDeviceInfo(@Query("id_menu") menuId: Int): retrofit2.Call<DeviceInformationNetwork>
}
