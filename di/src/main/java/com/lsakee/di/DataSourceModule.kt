package com.lsakee.di

import com.lsakee.data.remote.MenuDataSource
import com.lsakee.data_remote.datasource.MenuDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun providesMenuDataSource(menuDataSourceImpl: MenuDataSourceImpl): MenuDataSource
}