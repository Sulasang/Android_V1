package com.lsakee.suwon_sulasang.di

import com.lsakee.domain.repository.MenuRepository
import com.lsakee.domain.usecase.GetStaffMenuUseCase
import com.lsakee.domain.usecase.GetStudentMenuUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetStudentMenuUseCase(menuRepository: MenuRepository): GetStudentMenuUseCase {
        return GetStudentMenuUseCase(menuRepository)
    }

    @Singleton
    @Provides
    fun provideGetStaffMenuUseCase(menuRepository: MenuRepository): GetStaffMenuUseCase {
        return GetStaffMenuUseCase(menuRepository)
    }

}