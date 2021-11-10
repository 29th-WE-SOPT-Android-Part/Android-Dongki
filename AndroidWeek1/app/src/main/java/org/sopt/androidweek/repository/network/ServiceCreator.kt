package org.sopt.androidweek.repository.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.sopt.androidweek.repository.network.api.SampleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(provideOkHttpClient(AppInterceptor()))
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object SampleCreator {
    val sampleService: SampleService by lazy {
        retrofit.create(SampleService::class.java)
    }
}

private fun provideOkHttpClient(
    interceptor: AppInterceptor
): OkHttpClient = OkHttpClient.Builder()
    .run {
        addInterceptor(interceptor)
        build()
    }

class AppInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain)
            : Response = with(chain) {
        val newRequest = request().newBuilder()
            .addHeader("cute","Content-Type: application/json")
            .build()
        proceed(newRequest)
    }
}