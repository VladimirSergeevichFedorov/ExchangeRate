package com.example.exchangerate.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangerate.domain.entities.ExchangeRate
import com.example.exchangerate.domain.usecase.LocalBDUseCase
import com.example.exchangerate.utils.safeLaunch
import com.example.exchangerate.utils.state
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val localBDUseCase: LocalBDUseCase
): ViewModel() {

    var favoritesValuatesFlow by state(emptyList<ExchangeRate>())
        private set

    init {
        viewModelScope.safeLaunch {
            localBDUseCase.getFavoritesValute().collect{
                favoritesValuatesFlow = it
            }
        }
    }

    fun deleteValute(exchangeRate: ExchangeRate){
        viewModelScope.safeLaunch(dispatcher = Dispatchers.IO) {
            localBDUseCase.deleteFavoritesValute(exchangeRate)
        }
    }
}