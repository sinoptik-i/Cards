package com.sinoptik_.cards.view.bottom_menu

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
import com.ramcosta.composedestinations.utils.rememberDestinationsNavigator
import com.ramcosta.composedestinations.utils.startDestination
import com.sinoptik_.cards.view.bottom_menu.BottomMenuItem


@Composable
fun BottomMenu(
    navController: NavHostController,
) {
    val destinationsNavigator: DestinationsNavigator = navController.rememberDestinationsNavigator()
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
                onClick = {
                    destinationsNavigator.navigate(item.route) {
                        launchSingleTop = true
                    }
                },
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
