package com.sinoptik_.cards.viewModels

import android.R.attr.country
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.room.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AllCardsVM @Inject constructor(
    val cardRepository: CardRepository
) : ViewModel() {

    private val _cards: MutableStateFlow<List<BankCard>> = MutableStateFlow(emptyList())

    //    val cards = _cards.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    val cards = cardRepository.getCardsFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


//    fun loadCards() {
//        viewModelScope.launch {
//            _cards = cardRepository.getCardsFlow()
//        }
//    }

    fun getTestCards() {
        viewModelScope.launch {
            val list = mutableListOf<BankCard>()
            for (i in 1..7) {
                list.add(
                    createTestCard().copy(
                        cardBinNumber = (10000000 * i).toString()
                    )
                )
            }
            delay(1000)
            _cards.value = list
        }
    }

    private fun createTestCard() =
        BankCard(
            cardBinNumber = "1234 5678",


            bankName = "PREMIER BANK",
            cardType = "VISA",

            country = "DK Denmark",
            latitude = "56",
            longitude = "10",

            url = "www.jyskebank.dk",
            phone = "+4589893300",
            city = "Herring",
        )


}