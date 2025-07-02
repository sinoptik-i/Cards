package com.sinoptik_.cards.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.data.dto.FullCard
import com.sinoptik_.cards.view.components.InputTextField
import com.sinoptik_.cards.viewModels.InputBinScreenVM


@Composable
fun InputBinScreen(
    paddingValues: PaddingValues,
    viewmodel: InputBinScreenVM = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
//        .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        var textBin by remember { viewmodel.textBin }
        val cardState by viewmodel.card.collectAsStateWithLifecycle()

        val syncState by viewmodel.state.collectAsStateWithLifecycle()

        Box {
            when (syncState) {
                is InProgress -> {
                    ProgressBar()
                }

                //trash
                is Success -> {
//                    val newCard = (syncState as Success<FullCard>).data.toBankCard(textBin)
//                    viewmodel.cardRepository.insertCard(newCard)
                    BankCardTemplate((syncState as Success<BankCard>).data)
                }

                is Failed -> {
                    Text("${(syncState as Failed).throwable.message}")
                }

                is UnUsed -> {}
            }
        }

        InputTextField(
            text = textBin,
            onValueChange = {
                viewmodel.textBin.value = it
            }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
//                viewmodel.testLoadCard()
//                viewmodel.loadCard()
                viewmodel.loadState()
            },

            ) {
            Text("Load Card Info")
        }
    }
}

@Composable
fun ProgressBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    )
    {
        CircularProgressIndicator(
            modifier = Modifier
                .size(56.dp)
        )
    }
}