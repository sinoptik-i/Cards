package com.sinoptik_.cards.view

//@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.view.bottomMenu.BottomMenu


@Composable
fun MainScreen() {

    var selectedMenuItem by remember { mutableStateOf("card") }

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
    ) { paddingValues ->
        if (selectedMenuItem == "card") {
            InputBinScreen(paddingValues)
        } else {
            AllCards(paddingValues)
        }
    }


}

