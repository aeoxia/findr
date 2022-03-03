package com.ausom.data

import com.ausom.domain.abstraction.FindrRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *  Dependency binding of data module
 */
@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @get:[Binds Singleton]
    val FindrRepositoryImpl.oinkyRepository: FindrRepository
}