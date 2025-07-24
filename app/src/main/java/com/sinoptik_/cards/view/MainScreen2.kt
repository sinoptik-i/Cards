package com.sinoptik_.cards.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.NavGraphs
import com.sinoptik_.cards.view.bottomMenu.BottomMenu

//@Destination<RootGraph>
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen2() {

//    var selectedMenuItem by remember { mutableStateOf("card") }
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            BottomMenu(
                selectedItem = selectedMenuItem,
                onItemClick = {
                    selectedMenuItem = it
                }
            )
        }
    )
    { DestinationsNavHost(
        navController = navController,
        navGraph = NavGraphs.root
    )
    }


}