package com.example.exchangerate.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangerate.domain.entities.ExchangeRate
import com.example.exchangerate.domain.usecase.ListOfCurrenciesUseCase
import com.example.exchangerate.domain.usecase.LocalBDUseCase
import com.example.exchangerate.utils.safeLaunch
import com.example.exchangerate.utils.state
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val listOfCurrenciesUseCase: ListOfCurrenciesUseCase,
    private val localBDUseCase: LocalBDUseCase
) : ViewModel() {

    var valuatesFlow by state(emptyList<ExchangeRate>())
        private set

    init {
        viewModelScope.safeLaunch {
            valuatesFlow =  listOfCurrenciesUseCase.getCurrencies()
        }
    }
    fun saveValuteForbd(exchangeRate: ExchangeRate){
        viewModelScope.safeLaunch(dispatcher = Dispatchers.IO) {
            localBDUseCase.saveFavoritesValute(exchangeRate = exchangeRate)
        }
    }
}