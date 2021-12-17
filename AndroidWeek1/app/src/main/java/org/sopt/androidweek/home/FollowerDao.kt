package org.sopt.androidweek.home

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FollowerDao(
    @SerializedName("login")
    val name : String,
    @SerializedName("bio")
    val introduction : String?= null
) : Serializable
