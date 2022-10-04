package com.example.exchangerate.mapping

import com.example.exchangerate.data.remote.entities.Valute
import com.example.exchangerate.data.storage.entities.ValuteEntity
import com.example.exchangerate.domain.entities.ExchangeRate

interface DataMapper {
    fun mapValuteToExchangeRate(valute: Valute): ExchangeRate

    fun mapExchangeRateToValuteEntity(exchangeRate: ExchangeRate): ValuteEntity

    fun mapExchangeRateToValuteEntity(valuteEntity: ValuteEntity): ExchangeRate
}