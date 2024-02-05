package com.example.flights.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.flights.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.flights.presentation.ui.theme.FlightsTheme
import com.example.flights.presentation.ui.theme.Main050
import com.example.flights.presentation.ui.theme.Main100
import com.example.flights.presentation.ui.theme.Main250

@ExperimentalMaterial3Api
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit
) {
    val (containerColor, textColor)= when(isDarkTheme){
        true -> Main250 to Main050
        else -> Main050 to Main250
    }
    
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = stringResource(id = R.string.description_search),
                tint = Main100
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_flights),
                color = if (isDarkTheme) Main050.copy(0.7f) else Main250.copy(0.7f)
                )
        },
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_16)),
        colors= TextFieldDefaults.outlinedTextFieldColors(
            containerColor = containerColor,
            focusedBorderColor = containerColor,
            unfocusedBorderColor = containerColor,
            textColor = textColor,
        ),
        modifier= modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.size_16))
    )
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFF3F9FC
)
@ExperimentalMaterial3Api
@Composable
fun SearchBarLightPreview(){
    FlightsTheme {
        SearchBar(isDarkTheme = false, searchQuery = "", onSearchQueryChange = {} )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF3F9FC
)
@ExperimentalMaterial3Api
@Composable
fun SearchBarDarkPreview(){
    FlightsTheme {
        SearchBar(isDarkTheme = true, searchQuery = "", onSearchQueryChange = {} )
    }
}


