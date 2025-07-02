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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AllCards(
    paddingValues: PaddingValues,
    viewModel: AllCardsVM = hiltViewModel()
) {
//    val viewModel = AllCardsVM()
//    viewModel.getTestCards()

    val cards by viewModel.cards.collectAsStateWithLifecycle()


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
//            .padding(5.dp),
    ) {
        items(cards) { card ->
            BankCardTemplate(
                card
            )

        }

    }
}