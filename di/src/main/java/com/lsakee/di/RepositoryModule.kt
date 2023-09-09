package com.lsakee.di

import com.lsakee.data.repositoryImpl.MenuRepositoryImpl
import com.lsakee.domain.repository.MenuRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsMenuRepository(
        menuRepositoryImpl: MenuRepositoryImpl,
    ): MenuRepository
}