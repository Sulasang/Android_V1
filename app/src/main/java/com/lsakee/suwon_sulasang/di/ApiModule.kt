package com.lsakee.suwon_sulasang.di

import com.lsakee.data_remote.api.MenuApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideMenuApiService(@SulasangRetrofit retrofit: Retrofit): MenuApiService =
        retrofit.create(MenuApiService::class.java)
}