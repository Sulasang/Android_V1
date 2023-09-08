package com.lsakee.data.repositoryImpl

import com.lsakee.data.model.toDietDomain
import com.lsakee.data.remote.MenuDataSource
import com.lsakee.domain.model.Diet
import com.lsakee.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val dataSource: MenuDataSource,
) : MenuRepository {

    override suspend fun getDiet(date:String,type:String): Flow<Diet> {
        return flow {
            val result = kotlin.runCatching {
                dataSource.getDiet(date, type).result?.toDietDomain()
            }
            Timber.tag("LeeSak").d("$result")
            result.getOrDefault(Diet(emptyList()))?.let { emit(it) }
        }
    }

}