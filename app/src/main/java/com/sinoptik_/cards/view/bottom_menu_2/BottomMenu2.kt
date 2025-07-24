package com.sinoptik_.cards.view.bottom_menu_2

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import com.ramcosta.composedestinations.utils.startDestination
import com.sinoptik_.cards.view.bottomMenu.BottomMenuItem


@Composable
fun BottomMenu2(
    navController: NavHostController,
    destinationsNavigator: DestinationsNavigator
) {
    val items = listOf(
        BottomMenuItem.Card,
        BottomMenuItem.Cards
    )
    val currentDestination: DestinationSpec = navController.currentDestinationAsState().value
        ?: NavGraphs.root.startDestination


    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentDestination == item.route,
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
