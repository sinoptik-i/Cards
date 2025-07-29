package com.sinoptik_.cards.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs
import com.sinoptik_.cards.view.bottom_menu.BottomMenu

//@Destination<RootGraph>
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            BottomMenu(
                navController = navController,
            )
        }
    )
    {
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.root
        )
    }


}