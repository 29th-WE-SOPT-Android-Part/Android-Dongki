package org.sopt.androidweek.repository.dto.response

import org.sopt.androidweek.repository.dto.Data

data class SignUpResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
)
