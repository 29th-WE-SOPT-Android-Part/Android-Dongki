package org.sopt.androidweek.repository.network.api

import org.sopt.androidweek.repository.dto.request.SignUpRequest
import org.sopt.androidweek.repository.dto.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SampleService {
    @POST("user/signup")
    suspend fun requestSignUp(
        @Body body: SignUpRequest
    ): SignUpResponse

    @POST("user/login")
    suspend fun requestLogIn(
        @Body body: SignUpRequest
    ): SignUpResponse
}