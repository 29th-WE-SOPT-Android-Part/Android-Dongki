package org.sopt.androidweek.repository.dto.response

import org.sopt.androidweek.repository.dto.Data

open class GeneralResponseData(
    val status: Int? = null,
    val success: Boolean? = null,
    val message: String? = null
)

data class SignUpResponse(
    val data: Data
) : GeneralResponseData()

