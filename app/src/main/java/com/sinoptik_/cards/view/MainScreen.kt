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


//@Composable
//fun BankCardTemplate(
//    card: BankCard = BankCard(),
//    showBack: Boolean = false,
//    modifier: Modifier = Modifier
//) {
//    Card(
//        modifier = modifier
//            .width(340.dp)
//            .height(214.dp),
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        if (showBack) {
//            CardBackSide(card = card)
//        } else {
//            CardFrontSide(card = card)
//        }
//    }
//}

@Composable
private fun CardFrontSide(card: BankCard) {
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
            // Top section with bank name and card type
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = card.bankName,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = card.cardType,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }

            // Chip section
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(28.dp)
                    .background(
                        Color(0xFFFFD700),
                        RoundedCornerShape(4.dp)
                    )
            ) {
                // Simulated chip pattern
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(3) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            repeat(4) {
                                Box(
                                    modifier = Modifier
                                        .size(2.dp)
                                        .background(Color(0xFFB8860B))
                                )
                            }
                        }
                    }
                }
            }

            // Card number
            Text(
                text = card.cardBinNumber,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.Monospace
            )

            // Bottom section with name and expiry
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "CARD HOLDER",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = card.cardHolderName,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "EXPIRES",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = card.expiryDate,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Decorative circles
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

@Composable
private fun CardBackSide(card: BankCard) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF764ba2),
                        Color(0xFF667eea)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Magnetic stripe
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .offset(y = 20.dp)
                    .background(Color.Black)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Signature strip and CVV
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(30.dp)
                        .background(Color.White, RoundedCornerShape(4.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = card.cvv,
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Terms and conditions text
            Text(
                text = "This card is property of ${card.bankName}. If found, please return to any branch or call customer service. Unauthorized use is prohibited and subject to prosecution.",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 8.sp,
                modifier = Modifier.padding(horizontal = 20.dp),
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.weight(1f))

            // Bank logo area at bottom
            Text(
                text = card.bankName,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.End)
            )
        }
    }
}

@Composable
fun BankCardDemo() {
    var showBack by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        BankCardTemplate(
//            showBack = showBack
//        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { showBack = !showBack },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF667eea)
            )
        ) {
            Text(
                text = if (showBack) "Show Front" else "Show Back",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Custom card example
//        BankCardTemplate(
//            card = BankCard(
//                cardBinNumber = "4532 1234 5678 9012",
//                cardHolderName = "JANE SMITH",
//                expiryDate = "06/27",
//                cvv = "456",
//                bankName = "TECH BANK",
//                cardType = "MASTERCARD"
//            ),
//            showBack = showBack
//        )
//    }
    }
}

//@Preview(showBackground = true)
@Composable
fun BankCardPreview() {
    MaterialTheme {
        BankCardDemo()
    }
}