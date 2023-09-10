package com.lsakee.data_remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("status")
    val status: Int,
    @SerialName("result")
    val result: T ?= null,
)