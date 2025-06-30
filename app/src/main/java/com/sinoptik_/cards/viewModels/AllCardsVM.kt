package com.sinoptik_.cards.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinoptik_.cards.data.BankCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AllCardsVM : ViewModel() {

   private val _cards: MutableStateFlow<List<BankCard>> = MutableStateFlow(emptyList())

    val cards = _cards.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun getTestCards() {
        viewModelScope.launch {
            val list = mutableListOf<BankCard>()
            for (i in 1..7) {
                list.add(
                    BankCard(
                        cardBinNumber = (10000000 * i).toString()
                    )
                )
            }
            delay(1000)
            _cards.value=list
        }
    }


}