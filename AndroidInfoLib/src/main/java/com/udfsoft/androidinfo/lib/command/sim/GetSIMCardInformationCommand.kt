package com.udfsoft.androidinfo.lib.command.sim

import android.Manifest
import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import androidx.annotation.RequiresPermission
import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.entity.SIMCardInformation

class GetSIMCardInformationCommand(
    private val context: Context
) : CommandInterface<Unit, SIMCardInformation> {

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, "android.permission.READ_PHONE_NUMBERS"]
    )
    override fun invoke(param: Unit): SIMCardInformation {
        val telephonyService =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        val callState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyService.callStateForSubscription
        } else {
            telephonyService.callState
        }

        val isMultiSimSupported = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            telephonyService.isMultiSimSupported
        } else {
            1
        }

        val deviceSoftwareVersion: String? = telephonyService.deviceSoftwareVersion
        val mobileNumber: String? = telephonyService.line1Number
        val simOperatorName: String? = telephonyService.simOperatorName
        val simState = telephonyService.simState
        val simCountryIso = telephonyService.simCountryIso

        return SIMCardInformation(
            deviceSoftwareVersion,
            mobileNumber,
            simOperatorName,
            callState,
            simState,
            simCountryIso,
            isMultiSimSupported
        )
    }
}