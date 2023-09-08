package com.lsakee.domain.usecase

import com.lsakee.domain.model.Diet
import com.lsakee.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow

class GetDietUseCase(
    private val repository: MenuRepository
) {
    suspend operator fun invoke(date:String,type:String): Flow<Diet> =
        repository.getDiet(date,type)

}