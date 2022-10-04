package com.example.exchangerate.mapping

import com.example.exchangerate.data.remote.entities.Valute
import com.example.exchangerate.data.storage.entities.ValuteEntity
import com.example.exchangerate.domain.entities.ExchangeRate
import javax.inject.Inject

class MappersValuteData @Inject constructor(): DataMapper {
    override fun mapValuteToExchangeRate(valute: Valute) = ExchangeRate(
        id = valute.id,
        value = valute.value.toBigDecimal(),
        valute = valute.charCode
    )
    override fun mapExchangeRateToValuteEntity(exchangeRate: ExchangeRate) = ValuteEntity(
        valuteId = exchangeRate.id,
        value = exchangeRate.value.toString(),
        charCode = exchangeRate.valute
    )

    override fun mapExchangeRateToValuteEntity(valuteEntity: ValuteEntity) = ExchangeRate(
        id = valuteEntity.valuteId,
        value = valuteEntity.value.toBigDecimal(),
        valute = valuteEntity.charCode
    )
}