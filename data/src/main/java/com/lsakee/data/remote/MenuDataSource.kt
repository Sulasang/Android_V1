package com.lsakee.data.remote

import com.lsakee.data.BaseResponse
import com.lsakee.data.model.DietDto

interface MenuDataSource {
    suspend fun getDiet(date: String, type: String): BaseResponse<DietDto>
}