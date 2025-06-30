package com.sinoptik_.cards.data

data class BankCard(
    val cardBinNumber: String = "1234 5678",
    val cardHolderName: String = "JOHN DOE",
    val expiryDate: String = "12/28",
    val cvv: String = "123",
    val bankName: String = "PREMIER BANK",
    val cardType: String = "VISA",

    val country: String = "DK Denmark",
    val latitude: String = "56",
    val longitude: String = "10",

    val url : String = "www.jyskebank.dk",
    val phone : String = "+4589893300",
    val city : String = "Herring",

)