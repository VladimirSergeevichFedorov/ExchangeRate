package com.example.exchangerate.ui.viewbar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.example.exchangerate.R

private const val EMPTY_STRING = ""
private const val FONT_SIZE = 18

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier,
        textStyle = TextStyle(fontSize = FONT_SIZE.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.fifteen_dp))
                    .size(dimensionResource(R.dimen.twenty_four_dp)),
                tint = MaterialTheme.colors.background
            )
        },
        trailingIcon = {
            if (state.value.text.isNotEmpty()) {
                IconButton(
                    onClick = {
                        state.value = TextFieldValue(EMPTY_STRING)
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(dimensionResource(R.dimen.fifteen_dp))
                            .size(dimensionResource(R.dimen.twenty_four_dp)),
                        tint = MaterialTheme.colors.background
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Unspecified,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}