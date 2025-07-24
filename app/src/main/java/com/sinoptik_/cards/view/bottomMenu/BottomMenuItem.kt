package com.sinoptik_.cards.view.bottomMenu

import com.ramcosta.composedestinations.generated.destinations.InputBinScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import com.sinoptik_.cards.R

sealed class BottomMenuItem(
    val route: DirectionDestinationSpec,
    val title: String,
    val iconId: Int

) {

    object Card : BottomMenuItem(
        route = InputBinScreenDestination,
        title = "new card",
        iconId = R.drawable.ic_card
    )

    object Cards : BottomMenuItem(
        route = "cards",
        title = "cards",
        iconId = R.drawable.ic_cards
    )



}