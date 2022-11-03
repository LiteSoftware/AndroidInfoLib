/*
 * Copyright 2022 Javavirys
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.udfsoft.androidinfo.lib.di

import com.udfsoft.androidinfo.lib.BuildConfig
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.interceptor.StaticHeadersInterceptor
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkFactory {

    private const val SERVER_HOST = "https://androidinfo.udfsoft.com/androidinfo/api/"

    private const val CACHE_SIZE = (5 * 1024 * 1024).toLong()

    private const val TIMEOUT = 30L

    private var retrofitInstance: Retrofit? = null

    private var apiInstance: AndroidInfoApi? = null

    private fun getHttpLoggingInterceptor() = HttpLoggingInterceptor().also {
        it.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    private fun getHttpClientWithoutCache(
        staticHeadersInterceptor: StaticHeadersInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient().newBuilder()
        .certificatePinner(CertificatePinner.Builder().build())
        .protocols(listOf(Protocol.HTTP_1_1))
        .addInterceptor(staticHeadersInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .build()

    private fun getRetrofitWithoutCache(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(SERVER_HOST)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getRetrofit() = if (retrofitInstance == null) {
        val httpLoggingInterceptor = getHttpLoggingInterceptor()
        val httpClient = getHttpClientWithoutCache(
            StaticHeadersInterceptor(), httpLoggingInterceptor
        )

        getRetrofitWithoutCache(httpClient).also {
            retrofitInstance = it
        }
    } else {
        retrofitInstance!!
    }

    fun getAndroidInfoApi(retrofit: Retrofit): AndroidInfoApi =
        retrofit.create(AndroidInfoApi::class.java)

    fun getAndroidInfoApi(): AndroidInfoApi = if (apiInstance == null) {
        val retrofit = getRetrofit()
        retrofit.create(AndroidInfoApi::class.java).also { apiInstance = it }
    } else {
        apiInstance!!
    }
}