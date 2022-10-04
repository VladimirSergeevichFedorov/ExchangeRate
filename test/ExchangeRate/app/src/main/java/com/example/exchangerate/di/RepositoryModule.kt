package com.example.exchangerate.di

import com.example.exchangerate.data.remote.ListOfCurrenciesImpl
import com.example.exchangerate.data.storage.LocalBDImpl
import com.example.exchangerate.domain.repo.ListOfCurrenciesRepo
import com.example.exchangerate.domain.repo.LocalBDRepo
import com.example.exchangerate.mapping.DataMapper
import com.example.exchangerate.mapping.MappersValuteData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNetworkInterface(impl: ListOfCurrenciesImpl): ListOfCurrenciesRepo

    @Binds
    abstract fun bindLocalBDInterface(impl: LocalBDImpl): LocalBDRepo

    @Binds
    abstract fun mapper(impl: MappersValuteData): DataMapper
}