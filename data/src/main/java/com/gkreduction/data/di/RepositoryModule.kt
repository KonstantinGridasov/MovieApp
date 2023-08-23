package com.gkreduction.data.di

import com.gkreduction.data.repository.NetworkRepositoryImpl
import com.gkreduction.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNetworkRepository(repository: NetworkRepositoryImpl): NetworkRepository = repository
}