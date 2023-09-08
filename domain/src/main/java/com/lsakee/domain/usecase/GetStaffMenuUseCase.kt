package com.lsakee.domain.usecase

import com.lsakee.domain.model.Menu
import com.lsakee.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow


class GetStaffMenuUseCase (
    private val repository: MenuRepository
) {
    suspend operator fun invoke() : Flow<Menu> =
        repository.getStaffMenu()

}