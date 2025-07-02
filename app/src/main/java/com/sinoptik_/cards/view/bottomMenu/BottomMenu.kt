package com.sinoptik_.cards.view.bottomMenu

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource


@Composable
fun BottomMenu(
    selectedItem: String,
    onItemClick: (String) -> Unit
) {
    val items = listOf(
        BottomMenuItem.Card,
        BottomMenuItem.Cards
    )



    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = selectedItem == item.route,
                onClick = { onItemClick(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = item.iconId
                        ),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        item.title
                    )
                },
            )

        }
    }

}