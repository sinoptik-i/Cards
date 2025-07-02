package com.sinoptik_.cards.data.dto

import com.sinoptik_.cards.data.BankCard
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
    @SerialName("bank") var bank: Bank? = Bank()
){
    fun toBankCard(textBin: String)= BankCard(
        cardBinNumber = textBin,
        bankName = bank?.name ?: "",
        cardType = scheme ?: "",
        country = country?.name ?: "",
        latitude = country?.latitude.toString() ?: "",
        longitude = country?.longitude.toString() ?: "",
        url = bank?.url ?: "",
        phone = bank?.phone ?: "",
        city = bank?.city ?: ""
    )
}