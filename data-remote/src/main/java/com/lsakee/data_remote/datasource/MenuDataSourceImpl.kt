package com.lsakee.data_remote.datasource

import com.lsakee.data.BaseResponse
import com.lsakee.data.model.MenuEntity
import com.lsakee.data.remote.MenuDataSource
import com.lsakee.data_remote.api.MenuApiService
import javax.inject.Inject

class MenuDataSourceImpl @Inject constructor(
    private val apiService: MenuApiService
) : MenuDataSource {

    override suspend fun getStudentMenu(): BaseResponse<MenuEntity> {
        return apiService.getStaffMenu()
    }

    override suspend fun getStaffMenu(): BaseResponse<MenuEntity> {
        return apiService.getStaffMenu()
    }

}