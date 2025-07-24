package com.sinoptik_.cards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs
import com.sinoptik_.cards.ui.theme.CardsTheme
import com.sinoptik_.cards.view.AllCards
import com.sinoptik_.cards.view.InputBinScreen
import com.sinoptik_.cards.view.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CardsTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
