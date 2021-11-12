package org.sopt.androidweek.repository.network

import org.sopt.androidweek.repository.network.api.GitService
import org.sopt.androidweek.repository.network.api.SampleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object GitCreator {
    val gitService: GitService by lazy {
        retrofit.create(GitService::class.java)
    }
}