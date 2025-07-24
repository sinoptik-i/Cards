package com.sinoptik_.cards.view.bottomMenu

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.generated.destinations.AllCardsDestination
import com.ramcosta.composedestinations.generated.destinations.InputBinScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import com.ramcosta.composedestinations.utils.startDestination


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


enum class BottomBarDestination(
    val direction: DirectionDestinationSpec<T>,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    InputBinScreen(InputBinScreenDestination, Icons.Default.Home, R.string.greeting_screen),
    AllCards(AllCardsDestination, Icons.Default.Email, R.string.feed_screen),
}

@Composable
fun BottomBar(
    // you can get one `DestinationsNavigator` by calling `navController.toDestinationsNavigator()
    // or navController.rememberDestinationsNavigator() when in a Composable function`
    destinationsNavigator: DestinationsNavigator
) {
    val currentDestination: DestinationSpec = navController.currentDestinationAsState().value
        ?: NavGraphs.root.startDestination

    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    destinationsNavigator.navigate(destination.direction) {
                        launchSingleTop = true
                    }
                },
                icon = { Icon(destination.icon, contentDescription = stringResource(destination.label))},
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}
