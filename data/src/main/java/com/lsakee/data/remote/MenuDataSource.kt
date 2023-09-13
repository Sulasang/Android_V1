package com.lsakee.data.remote

import com.lsakee.data.model.DietData
import kotlinx.coroutines.flow.Flow

interface MenuDataSource {
    suspend fun getDiet(date: String, type: String): Flow<DietData>
}