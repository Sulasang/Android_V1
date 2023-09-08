package com.lsakee.domain.repository

import com.lsakee.domain.model.Menu
import com.lsakee.domain.model.Space
import kotlinx.coroutines.flow.Flow

interface MenuRepository {

    suspend fun getStudentMenu(): Flow<Menu>

    suspend fun getStaffMenu(): Flow<Menu>


}