package com.udfsoft.androidinfo.lib.command.sim

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.entity.SIMCardInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetSIMCardInformationCommand(
    private val context: Context,
    private val api: AndroidInfoApi
) : CommandInterface<Unit, SIMCardInformation> {

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, "android.permission.READ_PHONE_NUMBERS"]
    )
    override fun invoke(param: Unit): SIMCardInformation {
        val localEntity = GetLocalSIMCardInformationCommand(context).invoke(Unit)
        val networkEntity = GetNetworkSIMCardInformationCommand(api).invoke(Unit)

        return SIMCardInformation(localEntity, networkEntity)

    }
}