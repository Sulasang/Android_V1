package com.lsakee.data_remote.datasource

import com.lsakee.data.model.DietData
import com.lsakee.data.remote.MenuDataSource
import com.lsakee.data_remote.api.MenuApiService
import com.lsakee.data_remote.model.toDietData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MenuDataSourceImpl @Inject constructor(
    private val apiService: MenuApiService
) : MenuDataSource {

    override suspend fun getDiet(date: String, type: String): Flow<DietData> {
        return flow {
            val result = kotlin.runCatching {
                apiService.getDiet(date, type).result?.toDietData()
            }
            result.getOrDefault(DietData(emptyList()))?.let { emit(it) }
        }
    }


}