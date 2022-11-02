package com.udfsoft.androidinfo.lib.network.interceptor

import android.os.Build
import com.udfsoft.androidinfo.lib.BuildConfig
import com.udfsoft.androidinfo.lib.network.Headers.ACCEPT
import com.udfsoft.androidinfo.lib.network.Headers.ACCEPT_LANGUAGE
import com.udfsoft.androidinfo.lib.network.Headers.APPLICATION_JSON_CONTENT_TYPE
import com.udfsoft.androidinfo.lib.network.Headers.CONTENT_TYPE
import com.udfsoft.androidinfo.lib.network.Headers.DEVICE_BRAND_KEY
import com.udfsoft.androidinfo.lib.network.Headers.DEVICE_MODEL_KEY
import com.udfsoft.androidinfo.lib.network.Headers.USER_AGENT
import com.udfsoft.androidinfo.lib.util.DeviceUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class StaticHeadersInterceptor : Interceptor {

    private val userAgent = DeviceUtils.getUserAgent(BuildConfig.LIBRARY_PACKAGE_NAME, "1.0.0")

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()
            .newBuilder()
            .addHeader(ACCEPT, APPLICATION_JSON_CONTENT_TYPE)
            .addHeader(CONTENT_TYPE, APPLICATION_JSON_CONTENT_TYPE)
            .addHeader(USER_AGENT, userAgent)
            .addHeader(ACCEPT_LANGUAGE, Locale.getDefault().language)
            .addHeader(DEVICE_BRAND_KEY, Build.BRAND)
            .addHeader(DEVICE_MODEL_KEY, Build.MODEL)

        return chain.proceed(requestBuilder.build())
    }
}