package com.lsakee.data.remote

import com.lsakee.data.BaseResponse
import com.lsakee.data.model.MenuEntity

interface MenuDataSource {
    suspend fun getStudentMenu(): BaseResponse<MenuEntity>
    suspend fun getStaffMenu(): BaseResponse<MenuEntity>


}