package com.lsakee.suwon_sulasang.di

import com.lsakee.domain.repository.MenuRepository
import com.lsakee.domain.usecase.GetDietUseCase
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
    fun provideGetDietUseCase(menuRepository: MenuRepository): GetDietUseCase {
        return GetDietUseCase(menuRepository)
    }

}