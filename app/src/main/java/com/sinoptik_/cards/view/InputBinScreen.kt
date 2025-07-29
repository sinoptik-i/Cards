package com.sinoptik_.cards.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.view.components.InputTextField
import com.sinoptik_.cards.viewModels.InputBinScreenVM


@Destination<RootGraph>(start = true)
@Composable
fun InputBinScreen(
    id: Int = 1,
    viewmodel: InputBinScreenVM = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var textBin by remember { viewmodel.textBin }
        val loadState by viewmodel.loadState.collectAsStateWithLifecycle()
        Box {
            when (loadState) {
                is InProgress -> {
                    ProgressBar()
                }

                is Success -> {
                    BankCardTemplate((loadState as Success<BankCard>).data)
                }

                is Failed -> {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        text = "${(loadState as Failed).throwable.message}"
                    )
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            onClick = {
                viewmodel.loadCard()
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