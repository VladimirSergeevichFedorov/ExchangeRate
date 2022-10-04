package com.example.exchangerate.domain.repo

import com.example.exchangerate.domain.entities.ExchangeRate
import kotlinx.coroutines.flow.Flow

interface LocalBDRepo {

    suspend fun getValuteFromDB(): Flow<List<ExchangeRate>>

    suspend fun saveValute(valute: ExchangeRate)

    suspend fun deleteValute(valute: ExchangeRate)
}