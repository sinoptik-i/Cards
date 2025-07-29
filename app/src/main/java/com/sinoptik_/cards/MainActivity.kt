package com.sinoptik_.cards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sinoptik_.cards.ui.theme.CardsTheme
import com.sinoptik_.cards.view.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CardsTheme {
                MainScreen()
//                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
