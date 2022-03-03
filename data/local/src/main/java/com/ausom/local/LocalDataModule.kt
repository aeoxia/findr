package com.ausom.local

import android.content.Context
import androidx.room.Room
import com.ausom.data.LocalDataSource
import com.ausom.local.dao.PhotoDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface LocalDataModule {

    @get:[Binds Singleton]
    val LocalDataSourceImpl.localDataSource: LocalDataSource

    companion object {

        @[Provides Singleton]
        fun provideMovieDao(appDatabase: FindrDatabase): PhotoDao {
            return appDatabase.photoDao()
        }

        @[Provides Singleton]
        fun provideAppDatabase(@ApplicationContext applicationContext: Context): FindrDatabase {
            return Room.databaseBuilder(
                applicationContext,
                FindrDatabase::class.java, "findr-db"
            ).build()
        }
    }
}