package com.udfsoft.androidinfo.lib.command

import android.app.ActivityManager
import android.content.Context
import com.udfsoft.androidinfo.lib.entity.RAMInformation

class GetRAMInformationCommand(
    private val context: Context
) : CommandInterface<Unit, RAMInformation> {

    override fun invoke(param: Unit): RAMInformation {
        val mi = ActivityManager.MemoryInfo()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(mi)
        val usedMemory = mi.totalMem - mi.availMem

        return RAMInformation(mi.totalMem, mi.availMem, usedMemory)
    }
}