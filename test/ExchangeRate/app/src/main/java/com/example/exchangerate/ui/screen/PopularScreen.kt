package com.example.exchangerate.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.exchangerate.ui.viewmodels.PopularViewModel
import com.example.exchangerate.R
import com.example.exchangerate.utils.StateSorted
import com.example.exchangerate.utils.filterResult
import com.example.exchangerate.utils.flow
import com.example.exchangerate.utils.search

@Composable
fun PopularScreen(
    popularViewModel: PopularViewModel,
    stateSearchText: MutableState<TextFieldValue>,
    stateSorted: MutableState<StateSorted>
) {
    val valuates by popularViewModel::valuatesFlow.flow.collectAsState()

    Column(
        modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.twenty_five_dp),
                start = dimensionResource(R.dimen.ten_dp),
                end = dimensionResource(R.dimen.ten_dp),
                bottom = dimensionResource(R.dimen.sixty_five_dp),
            )
            .fillMaxSize()
    ) {

        val searchText = stateSearchText.value.text

        Text(text = stringResource(id = R.string.header_list_valute))
        LazyColumn(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
        ) {
            if (valuates.isNotEmpty()) {
                item {
                    valuates.filterResult(searchText, stateSorted, ::search).forEach { valute ->
                        Row(
                            modifier = Modifier
                                .padding(
                                    start = dimensionResource(R.dimen.five_dp),
                                    end = dimensionResource(R.dimen.five_dp)
                                )
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(text = valute.valute)
                            Text(
                                modifier = Modifier.padding(start = dimensionResource(R.dimen.ten_dp)),
                                text = valute.value.toString()
                            )
                            IconButton(
                                modifier = Modifier
                                    .weight(1f)
                                    .wrapContentSize(
                                        Alignment.CenterEnd
                                    ),
                                onClick = { popularViewModel.saveValuteForbd(valute) }
                            ) { Icon(Icons.Filled.StarBorder, null) }
                        }
                    }
                }
            }
        }
    }
}