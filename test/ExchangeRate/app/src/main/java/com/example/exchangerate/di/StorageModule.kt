package com.example.exchangerate.di

import android.content.Context
import androidx.room.Room
import com.example.exchangerate.data.storage.AppDatabase
import com.example.exchangerate.domain.repo.LocalBDRepo
import com.example.exchangerate.domain.usecase.LocalBDUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Singleton
    @Provides
    fun provideLocalRepositoryUseCase(impl: LocalBDRepo) = LocalBDUseCase(impl)

    @Singleton
    @Provides
    fun providerDatabase(@ApplicationContext context: Context): AppDatabase {

        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}