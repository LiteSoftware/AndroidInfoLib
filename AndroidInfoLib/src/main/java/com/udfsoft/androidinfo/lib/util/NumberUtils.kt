package com.udfsoft.androidinfo.lib.util

object NumberUtils {

    fun String.toSafeInt(): Int = try {
        Integer.decode(this)
    } catch (ex: NumberFormatException) {
        0
    }
}