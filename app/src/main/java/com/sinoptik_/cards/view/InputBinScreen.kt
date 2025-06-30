package com.sinoptik_.cards.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sinoptik_.cards.viewModels.InputBinScreenVM


@Composable
fun InputBinScreen(
//    viemodel: InputBinScreenVM = hiltViewModel()
) {
    val viewmodel= InputBinScreenVM()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        var textBin by remember { viewmodel.textBin }
        val cardState by viewmodel.card.collectAsStateWithLifecycle()


        cardState?.let { BankCardTemplate(it) }

        InputTextField(
            text = textBin,
            onValueChange = {
                textBin = it
            }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewmodel.testLoadCard()
            },

            ) {
            Text("Load Card Info")
        }


    }

}