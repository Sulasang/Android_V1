package com.lsakee.data_remote.api

import com.lsakee.data_remote.response.BaseResponse
import com.lsakee.data.model.DietData
import com.lsakee.data_remote.model.DietDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MenuApiService {


    @GET("/v1/diet")
    suspend fun getDiet(
        @Query("date") date: String,
        @Query("type") type: String
    ): BaseResponse<DietDto>

    @GET("/v1/diet")
    suspend fun getDietDate(
        @Query("date") date: String,
        @Query("type") type: String
    ): BaseResponse<DietData>

}
