package com.weatherMinsk.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weatherMinsk.R
import com.weatherMinsk.presentation.ui.theme.WeatherTheme

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier.size(100.dp),
            painter = painterResource(id = R.drawable.baseline_cell_tower_24),
            contentDescription = stringResource(id = R.string.errorLoading)
        )

        Spacer(modifier = modifier.height(20.dp))

        Text(text = stringResource(id = R.string.errorLoading), fontSize = 18.sp)

        Spacer(modifier = modifier.height(20.dp))

        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.reload))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenView(){
    WeatherTheme {
        ErrorScreen(retryAction = { /*TODO*/ }, modifier = Modifier)
    }
}