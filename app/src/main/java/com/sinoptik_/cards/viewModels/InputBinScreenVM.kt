package com.sinoptik_.cards.viewModels

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

//    init{
//        viewModelScope.launch {
//            cardRepository.dropAll()
//        }
//    }

    //    45717360
    val textBin = mutableStateOf("")

    fun String.isNumeric(): Boolean {
        return this.all { it.isDigit() }
    }

    private fun checkBin(): Boolean {
        if (5 < textBin.value.length && textBin.value.length < 9) {
            if (textBin.value.isNumeric()) {
                return true
            }

        }
        return false
    }

    //----------------------------------------------------------------
    private val _loadState: MutableStateFlow<LoadState<FullCard>> =
        MutableStateFlow(UnUsed)

    fun loadCard() {
        viewModelScope.launch {
            if (checkBin()) {
                try {
                    _loadState.value = InProgress
                    delay(1000)
                    val newCard = Common.retrofitService.getCard(textBin.value)
                    Log.d("InputBinScreenVM", newCard.toString())
                    if (newCard.scheme == null || newCard.bank?.name==null) {
                        _loadState.value = Failed(
                            Throwable(
                                "card not found"
                            )
                        )
                    } else {
                        _loadState.value = Success(newCard)
                    }
                    Log.d("InputBinScreenVM", _loadState.value.toString())
                } catch (e: IOException) {
                    Log.d("InputBinScreenVM", e.message.toString())
                    _loadState.value = Failed(
                        Throwable(
                            messagesForUser(e.message.toString())
                        )
                    )
                } catch (e: Exception) {
                    _loadState.value = Failed(
                        Throwable(
                            messagesForUser(e.message.toString())
                        )
                    )
                    Log.d("InputBinScreenVM", e.message.toString())
                }
            } else {
                _loadState.value = Failed(
                    Throwable(
                        "incorrect BIN"
                    )
                )
            }
        }
    }

    private fun messagesForUser(message: String): String {
        return if (message == "HTTP 429 ") {
            "You have exceeded the rate limit of 5 requests/hour. Please wait a bit and try again."
        } else if (message == "HTTP 400 ") {
            "incorrect BIN"
        } else {
            message
        }
    }


    val loadState = _loadState
        .map {
            val bcState: LoadState<BankCard> = when (it) {
                is InProgress -> InProgress
                is Failed -> Failed(it.throwable)
                is Success<FullCard> -> {
                    val newCard = it.data.toBankCard(textBin.value)
                    cardRepository.insertCard(newCard)
                    Success<BankCard>(newCard)
                }

                UnUsed -> UnUsed
            }
            bcState
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), InProgress)


}

