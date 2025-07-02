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
    cardRepository: CardRepository
) : ViewModel() {
    val cards = cardRepository.getCardsFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}