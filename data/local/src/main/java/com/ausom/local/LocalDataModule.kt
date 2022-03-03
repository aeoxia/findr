package com.ausom.local

import com.ausom.data.LocalDataSource
import com.ausom.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface LocalDataModule {

    @get:[Binds Singleton]
    val LocalDataSourceImpl.localDataSource: LocalDataSource

}