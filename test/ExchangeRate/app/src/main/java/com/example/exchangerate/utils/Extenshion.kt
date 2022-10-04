package com.example.exchangerate.utils

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.exchangerate.domain.entities.ExchangeRate
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

inline fun <T> Iterable<T>.filterResult(
    searchText: String, stateSorted: MutableState<StateSorted>,
    searchForList: (String, List<T>) -> List<ExchangeRate>
): List<ExchangeRate> {

    val resultSearch = (this as? List<T>)?.let { searchForList(searchText, it) } ?: emptyList()
    return when (stateSorted.value) {
        StateSorted.ALPHABETASCENDING -> resultSearch.sortedBy { it.valute }
        StateSorted.ALPHABETDESCENDING -> resultSearch.sortedBy { it.valute }
            .reversed()
        StateSorted.VALUEASCENDING -> resultSearch.sortedBy { it.value }
        StateSorted.VALUEDESCENDING -> resultSearch.sortedBy { it.value }
            .reversed()
        else -> {
            resultSearch
        }
    }
}

inline fun CoroutineScope.safeLaunch(
    dispatcher: CoroutineDispatcher? = null,
    crossinline launchBody: suspend () -> Unit
): Job {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("Exception", "CoroutineExceptionHandler got $exception")
    }

    val coroutineContext = if (dispatcher == null) this.coroutineContext + coroutineExceptionHandler else dispatcher + coroutineExceptionHandler

    return this.launch(coroutineContext) {
        launchBody.invoke()
    }
}

fun search(searchText: String, valuates: List<ExchangeRate>): List<ExchangeRate> {
    return if (searchText.isNotEmpty()) valuates.filter { it.valute.contains(searchText.uppercase()) } else valuates
}

