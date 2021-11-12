package org.sopt.androidweek.repository.network.api

import org.sopt.androidweek.home.FollowerDao
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("users/{username}/followers")
    suspend fun getGitHubFollowers(
        @Path("username") userName : String
    ) : List<FollowerDao>

    @GET("users/{username}")
    suspend fun getUserInfo(
        @Path("username") userName : String
    ) : FollowerDao
}