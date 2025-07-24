package com.sinoptik_.cards.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.sinoptik_.cards.view.bottomMenu.BottomMenu

//@Destination<RootGraph>
@Composable
fun MainScreen() {

//    var selectedMenuItem by remember { mutableStateOf("card") }
//
//    Scaffold(
//        modifier = Modifier
//            .fillMaxSize(),
//        bottomBar = {
//            BottomMenu(
//                selectedItem = selectedMenuItem,
//                onItemClick = {
//                    selectedMenuItem = it
//                }
//            )
//        }
//    ) { paddingValues ->
//        if (selectedMenuItem == "card") {
//            InputBinScreen(paddingValues)
//        } else {
//            AllCards(paddingValues)
//        }
//    }


}

