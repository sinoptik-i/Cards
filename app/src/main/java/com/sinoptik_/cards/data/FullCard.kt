package com.sinoptik_.cards.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class FullCard(

    @SerialName("number") var number: Number? = Number(),
    @SerialName("scheme") var scheme: String? = null,
    @SerialName("type") var type: String? = null,
    @SerialName("brand") var brand: String? = null,
    @SerialName("prepaid") var prepaid: Boolean? = false,
    @SerialName("country") var country: Country? = Country(),

//    "prepaid": false,
    @SerialName("bank") var bank: Bank? = Bank()

)