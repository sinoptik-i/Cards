package com.sinoptik_.cards.view.bottomMenu

import com.sinoptik_.cards.R

sealed class BottomMenuItem(
    val route: String,
    val title: String,
    val iconId: Int

) {
    object Card : BottomMenuItem(
        route = "card",
        title = "new card",
        iconId = R.drawable.ic_card
    )

    object Cards : BottomMenuItem(
        route = "cards",
        title = "cards",
        iconId = R.drawable.ic_cards
    )



}