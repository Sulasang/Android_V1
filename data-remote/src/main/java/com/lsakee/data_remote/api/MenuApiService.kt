package com.lsakee.data_remote.api

import com.lsakee.data.BaseResponse
import com.lsakee.data.model.MenuEntity
import retrofit2.http.GET

interface MenuApiService {

    @GET("/v1/staff-diet")
    suspend fun getStaffMenu(): BaseResponse<MenuEntity>

    @GET("/v1/student-diet")
    suspend fun getStudentMenu(): BaseResponse<MenuEntity>

}


