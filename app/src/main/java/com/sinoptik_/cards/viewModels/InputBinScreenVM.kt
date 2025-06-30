package com.sinoptik_.cards.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.data.FullCard
import com.sinoptik_.cards.retrofit.Common
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

class InputBinScreenVM: ViewModel() {

//    private val _card: MutableStateFlow<FullCard?> = MutableStateFlow(null)
    private val _card: MutableStateFlow<BankCard?> = MutableStateFlow(null)


    val textBin = mutableStateOf("")

    val card = _card
        .map {
            it?.copy(
                cardBinNumber=textBin.value
            )

//            BankCard(
//                cardBinNumber = textBin.value,
//                cardHolderName =it.,
//                expiryDate = TODO(),
//                cvv = TODO(),
//                bankName = TODO(),
//                cardType = TODO(),
//                country = TODO(),
//                latitude = TODO(),
//                longitude = TODO(),
//                url = TODO(),
//                phone = TODO(),
//                city = TODO()
//            )
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

//    fun loadCard(bin: String = "45717360") {
//
//        viewModelScope.launch {
//            try {
//                _card.value = Common.retrofitService.getCard(bin)
//            } catch (e: IOException) {
//                Log.d("cvvm", e.message.toString())
//            } catch (e: Exception) {
//                Log.d("cvvm", e.message.toString())
//
//            }
//        }
//    }

    fun testLoadCard() {
        viewModelScope.launch {
            delay(2000)
            _card.value= BankCard()

        }

    }


}