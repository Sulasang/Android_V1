package com.lsakee.domain.repository

import com.lsakee.domain.model.Diet
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    suspend fun getDiet(date: String, type: String): Flow<Diet>
}