package com.lsakee.data.repositoryImpl

import com.lsakee.data.extension.flatMapDomain
import com.lsakee.data.model.toDietDomain
import com.lsakee.data.remote.MenuDataSource
import com.lsakee.domain.model.Diet
import com.lsakee.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val dataSource: MenuDataSource,
) : MenuRepository {
//    override suspend fun getDiet(date: String, type: String): Flow<Diet> {
//        return dataSource.getDiet(date, type).flatMapConcat {
//            flow {
//                emit(it.toDietDomain())
//            }
//        }
//    }
    override suspend fun getDiet(date: String, type: String): Flow<Diet> {
        return dataSource.getDiet(date, type).flatMapDomain { it.toDietDomain() }
    }
}