package com.example.exchangerate.domain.usecase

import com.example.exchangerate.domain.repo.LocalBDRepo
import com.example.exchangerate.domain.entities.ExchangeRate

class LocalBDUseCase(private val localBDRepo: LocalBDRepo) {

    suspend fun saveFavoritesValute(exchangeRate: ExchangeRate) = localBDRepo.saveValute(exchangeRate)

    suspend fun deleteFavoritesValute(exchangeRate: ExchangeRate) = localBDRepo.deleteValute(exchangeRate)

    suspend fun getFavoritesValute() = localBDRepo.getValuteFromDB()
}