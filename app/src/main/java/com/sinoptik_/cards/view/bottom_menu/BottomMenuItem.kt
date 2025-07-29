package com.sinoptik_.cards.view.bottom_menu

import com.ramcosta.composedestinations.generated.destinations.AllCardsDestination
import com.ramcosta.composedestinations.generated.destinations.InputBinScreenDestination
import com.ramcosta.composedestinations.spec.Direction
import com.sinoptik_.cards.R

sealed class BottomMenuItem(
    val route: Direction,
    val title: String,
    val iconId: Int

) {
    object Card : BottomMenuItem(
        route = InputBinScreenDestination.invoke(),
        title = "new card",
        iconId = R.drawable.ic_card
    )
    object Cards : BottomMenuItem(
        route = AllCardsDestination.invoke(),
        title = "cards",
        iconId = R.drawable.ic_cards
    )
}