package com.lsakee.data.repositoryImpl

import com.lsakee.data.model.toMenuDomain
import com.lsakee.data.remote.MenuDataSource
import com.lsakee.domain.model.Days
import com.lsakee.domain.model.Menu
import com.lsakee.domain.model.Space
import com.lsakee.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val dataSource: MenuDataSource,
) : MenuRepository {
    override suspend fun getStudentMenu(): Flow<Menu> {
        return flow {
            val result = kotlin.runCatching {
                dataSource.getStudentMenu().result?.toMenuDomain()
            }
            result.getOrDefault(
                Menu(
                    "",
                    Days(emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
                )
            )?.let {
                emit(
                    it
                )
            }
        }
    }

    override suspend fun getStaffMenu(): Flow<Menu> {
        return flow {
            val result = kotlin.runCatching {
                dataSource.getStudentMenu().result?.toMenuDomain()
            }
            result.getOrDefault(
                Menu(
                    "",
                    Days(emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
                )
            )?.let {
                emit(
                    it
                )
            }
        }
    }

}