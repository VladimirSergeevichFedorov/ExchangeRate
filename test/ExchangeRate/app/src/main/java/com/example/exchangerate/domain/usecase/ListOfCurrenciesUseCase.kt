package com.example.exchangerate.domain.usecase

import com.example.exchangerate.domain.repo.ListOfCurrenciesRepo

class ListOfCurrenciesUseCase (private val listOfCurrenciesRepo: ListOfCurrenciesRepo) {

    suspend fun getCurrencies() = listOfCurrenciesRepo.getCurrencies()

}