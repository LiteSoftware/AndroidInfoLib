package com.udfsoft.androidinfo.lib.util

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.annotation.StringRes
import com.udfsoft.androidinfo.lib.R
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException
import java.util.*

object NetworkUtils {

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    fun getNetworkType(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getNetworkTypeForNewAndroid(it)
            } else {
                getNetworkTypeForOldAndroid(it)
            }
        }

    @RequiresApi(Build.VERSION_CODES.M)
    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    private fun getNetworkTypeForNewAndroid(connectivityManager: ConnectivityManager): NetworkType {
        val activeNetwork = connectivityManager.activeNetwork ?: return NetworkType.NONE

        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return NetworkType.NONE

        return when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkType.WIFI
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkType.CELLULAR
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> NetworkType.ETHERNET
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> NetworkType.BLUETOOTH
            else -> NetworkType.UNKNOWN
        }
    }

    @RequiresPermission(
        allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE]
    )
    private fun getNetworkTypeForOldAndroid(connectivityManager: ConnectivityManager): NetworkType {
        val activeNetwork = connectivityManager.activeNetworkInfo ?: return NetworkType.NONE
        if (!activeNetwork.isConnected) return NetworkType.NONE

        return when (activeNetwork.type) {
            ConnectivityManager.TYPE_WIFI -> NetworkType.WIFI
            ConnectivityManager.TYPE_MOBILE -> NetworkType.CELLULAR
            ConnectivityManager.TYPE_ETHERNET -> NetworkType.ETHERNET
            ConnectivityManager.TYPE_BLUETOOTH -> NetworkType.BLUETOOTH
            else -> NetworkType.UNKNOWN
        }
    }

    fun getLocalIpAddress(): String? {
        try {
            val en: Enumeration<NetworkInterface> = NetworkInterface.getNetworkInterfaces()
            while (en.hasMoreElements()) {
                val networkInterface: NetworkInterface = en.nextElement()
                val enumIpAddress: Enumeration<InetAddress> = networkInterface.inetAddresses
                while (enumIpAddress.hasMoreElements()) {
                    val inetAddress: InetAddress = enumIpAddress.nextElement()
                    if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                        return inetAddress.getHostAddress()
                    }
                }
            }
        } catch (ex: SocketException) {
            ex.printStackTrace()
        }

        return null
    }

    fun getMACAddress(interfaceName: String?): String? {
        try {
            val interfaces: List<NetworkInterface> =
                Collections.list(NetworkInterface.getNetworkInterfaces())
            interfaces.forEach {
                if (interfaceName != null) {
                    if (!it.name.equals(interfaceName, ignoreCase = true)) return@forEach
                }
                val mac = it.hardwareAddress ?: return null
                val buf = StringBuilder()
                for (aMac in mac) buf.append(String.format("%02X:", aMac))
                if (buf.isNotEmpty()) buf.deleteCharAt(buf.length - 1)
                return buf.toString()
            }
        } catch (ignored: Exception) {
        }

        return null
    }

    enum class NetworkType(@StringRes val nameId: Int) {
        WIFI(R.string.network_type_wifi),
        CELLULAR(R.string.network_type_cellular),
        ETHERNET(R.string.network_type_ethernet),
        BLUETOOTH(R.string.network_type_bluetooth),
        UNKNOWN(R.string.network_type_unknown),
        NONE(R.string.network_type_none)
    }
}