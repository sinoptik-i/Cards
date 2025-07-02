package com.sinoptik_.cards.viewModels

import android.R.attr.country
import android.util.Log
import android.util.Log.e
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.data.dto.FullCard
import com.sinoptik_.cards.retrofit.Common
import com.sinoptik_.cards.room.CardRepository
import com.sinoptik_.cards.view.Failed
import com.sinoptik_.cards.view.InProgress
import com.sinoptik_.cards.view.LoadState
import com.sinoptik_.cards.view.Success
import com.sinoptik_.cards.view.UnUsed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class InputBinScreenVM @Inject constructor(
    val cardRepository: CardRepository
) : ViewModel() {
//    init {
//        viewModelScope.launch {
//            cardRepository.dropAll()
//        }
//    }

    private val _card: MutableStateFlow<FullCard?> = MutableStateFlow(null)

    //    private val _textBin = mutableStateOf("")
//    val textBin =  stateOf (_textBin)
    val textBin = mutableStateOf("45717360")


    val card = _card
        .map {
            it?.let {
                try {
                    val newCard = it.toBankCard(textBin.value)
//                    val newCard = BankCard(
//                        cardBinNumber = textBin.value,
//                        bankName = it.bank?.name ?: "",
//                        cardType = it.scheme ?: "",
//                        country = it.country?.name ?: "",
//                        latitude = it.country?.latitude.toString() ?: "",
//                        longitude = it.country?.longitude.toString() ?: "",
//                        url = it.bank?.url ?: "",
//                        phone = it.bank?.phone ?: "",
//                        city = it.bank?.city ?: ""
//                    )
                    cardRepository.insertCard(newCard)
                    newCard
                } catch (ex: Exception) {
                    e("InputBinScreenVM", ex.message.toString())
                    null
                }
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    fun loadCard() {
        viewModelScope.launch {
            try {
                _card.value = Common.retrofitService.getCard(textBin.value)
                Log.d("InputBinScreenVM", _card.value.toString())
            } catch (e: IOException) {
                Log.d("InputBinScreenVM", e.message.toString())
                _card.value = null
            } catch (e: Exception) {
                _card.value = null
                Log.d("InputBinScreenVM", e.message.toString())
            }
        }
    }

    fun testLoadCard() {
        viewModelScope.launch {
            delay(2000)
            _card.value = FullCard()
            e("InputBinScreenVM", textBin.value)
        }
    }

    //----------------------------------------------------------------
    private val syncState: MutableStateFlow<LoadState<FullCard>> =
        MutableStateFlow(UnUsed)

    fun loadState() {
        viewModelScope.launch {
            try {
                syncState.value = InProgress
                delay(1000)
                syncState.value = Success(Common.retrofitService.getCard(textBin.value))
                Log.d("InputBinScreenVM", syncState.value.toString())
            } catch (e: IOException) {
                Log.d("InputBinScreenVM", e.message.toString())
                syncState.value = Failed(
                    Throwable(
                        e.message.toString()
                    )
                )
            } catch (e: Exception) {
                syncState.value = Failed(
                    Throwable(
                        e.message.toString()
                    )
                )
                Log.d("InputBinScreenVM", e.message.toString())
            }
        }
    }


    val state = syncState
        .map {
            val bcState: LoadState<BankCard> = when (it) {
                is InProgress -> InProgress
                is Failed -> Failed(it.throwable)
                is Success<FullCard> -> {
                    val newCard = (it as Success<FullCard>).data.toBankCard(textBin.value)
                    cardRepository.insertCard(newCard)
                    Success<BankCard>(newCard)
                }

                UnUsed -> UnUsed
            }
            bcState
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), InProgress)


}