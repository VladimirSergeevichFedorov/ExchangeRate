package com.example.exchangerate.data.storage

import com.example.exchangerate.data.storage.entities.ValuteEntity
import com.example.exchangerate.domain.repo.LocalBDRepo
import com.example.exchangerate.domain.entities.ExchangeRate
import com.example.exchangerate.mapping.DataMapper
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalBDImpl @Inject constructor(
    private val database: AppDatabase,
    private val mapper: DataMapper
) : LocalBDRepo {
    override suspend fun saveValute(valute: ExchangeRate) {
        database.rateDao().insertValute(mapper.mapExchangeRateToValuteEntity(valute))
    }

    override suspend fun deleteValute(valute: ExchangeRate) {
        database.rateDao().delete(mapper.mapExchangeRateToValuteEntity(valute))
    }

    override suspend fun getValuteFromDB(): Flow<List<ExchangeRate> >{
        return database.rateDao().getAll().map {
            it.map { valuteEntity ->
                mapper.mapExchangeRateToValuteEntity(
                    ValuteEntity(
                        valuteId = valuteEntity.valuteId,
                        charCode = valuteEntity.charCode,
                        value = valuteEntity.value
                    )
                )
            }
        }
    }
}