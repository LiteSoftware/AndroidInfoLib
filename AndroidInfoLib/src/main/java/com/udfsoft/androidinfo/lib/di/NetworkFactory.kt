package com.udfsoft.androidinfo.lib.di

import android.content.Context
import com.udfsoft.androidinfo.lib.BuildConfig
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi
import com.udfsoft.androidinfo.lib.network.interceptor.StaticHeadersInterceptor
import okhttp3.Cache
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkFactory {

    private const val SERVER_HOST = "https://androidinfo.udfsoft.com/androidinfo/api/"

    const val CACHE_MIN_AGE = 60 * 60 * 3

    const val CACHE_MAX_AGE = 60 * 60 * 24 * 7

    private const val CACHE_SIZE = (5 * 1024 * 1024).toLong()

    private const val TIMEOUT = 30L

    private var retrofitInstance: Retrofit? = null
    private var apiInstance: AndroidInfoApi? = null

    fun getCache(context: Context) = Cache(context.cacheDir, CACHE_SIZE)

    private fun getHttpLoggingInterceptor() = HttpLoggingInterceptor().also {
        it.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

//    fun provideHttpClientWithCache(
//        cache: Cache,
//        staticHeadersInterceptor: StaticHeadersInterceptor,
//        cacheControlInterceptor: CacheControlInterceptor,
//        httpLoggingInterceptor: HttpLoggingInterceptor
//    ): OkHttpClient = OkHttpClient().newBuilder()
//        .cache(cache)
//        .certificatePinner(CertificatePinner.Builder().build())
//        //        .retryOnConnectionFailure(true)
//        .protocols(listOf(Protocol.HTTP_1_1))
//        .addInterceptor(staticHeadersInterceptor)
//        .addInterceptor(httpLoggingInterceptor)
//        .addInterceptor(cacheControlInterceptor)
//        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
//        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
//        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
//        .build()

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

//    fun provideRetrofitWithCache(client: OkHttpClient): Retrofit =
//        Retrofit.Builder()
//            .baseUrl(BuildConfig.SERVER_HOST)
//            .client(client)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

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