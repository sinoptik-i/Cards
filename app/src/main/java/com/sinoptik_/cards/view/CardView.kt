package com.sinoptik_.cards.view

import android.R.attr.fontWeight
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinoptik_.cards.data.BankCard

@Preview

@Composable
fun BankCardTemplate(
    card: BankCard = BankCard(),
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(340f / 214f)
            .padding(
                horizontal = 6.dp,
                vertical = 3.dp
            ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        CardFrontSide(card = card)
    }
}

@Composable
private fun CardFrontSide(card: BankCard = BankCard()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF667eea),
                        Color(0xFF764ba2)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "${card.bankName}, ${card.city} ",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = card.url,
                        color = Color.White,
                        fontSize = 9.sp,
                    )
                    Text(
                        text = card.phone,
                        color = Color.White,
                        fontSize = 9.sp,
                    )
                }
                Text(
                    text = card.cardType,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }
            Text(
                text = card.cardBinNumber,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.Monospace
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = "COUNTRY",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = card.country,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "latitude: ${card.latitude}, longitude: ${card.longitude}",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

            }
        }
        Box(
            modifier = Modifier
                .size(60.dp)
                .offset(x = 280.dp, y = (-10).dp)
                .background(
                    Color.White.copy(alpha = 0.1f),
                    RoundedCornerShape(50)
                )
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .offset(x = 300.dp, y = 150.dp)
                .background(
                    Color.White.copy(alpha = 0.05f),
                    RoundedCornerShape(50)
                )
        )
    }
}

