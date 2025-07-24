package com.sinoptik_.cards.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sinoptik_.cards.viewModels.AllCardsVM
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.InputBinScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination<RootGraph>
@Composable
fun AllCards(
    id:Int=2,
//    paddingValues: PaddingValues,
    navigator: DestinationsNavigator,
    viewModel: AllCardsVM = hiltViewModel()
) {
//    val viewModel = AllCardsVM()
//    viewModel.getTestCards()

    val cards by viewModel.cards.collectAsStateWithLifecycle()


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(paddingValues),
//            .padding(5.dp),
    ) {
        item{
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                onClick = {
                     navigator.navigate(InputBinScreenDestination())
                },

                ) {
                Text("GOTO AllCards")
            }

        }
        items(cards) { card ->
            BankCardTemplate(
                card
            )

        }

    }
}