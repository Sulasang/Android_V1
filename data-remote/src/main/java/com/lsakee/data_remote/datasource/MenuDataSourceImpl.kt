package com.lsakee.data_remote.datasource

import com.lsakee.data.BaseResponse
import com.lsakee.data.model.DietDto
import com.lsakee.data.remote.MenuDataSource
import com.lsakee.data_remote.api.MenuApiService
import javax.inject.Inject

class MenuDataSourceImpl @Inject constructor(
    private val apiService: MenuApiService
) : MenuDataSource {

    override suspend fun getDiet(date:String,type:String): BaseResponse<DietDto> {
        return apiService.getDiet(date, type)
    }

}