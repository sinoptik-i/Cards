package com.sinoptik_.cards.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinoptik_.cards.data.FullCard
import com.sinoptik_.cards.retrofit.Common
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

class CardViewVM() : ViewModel() {

    private val _card: MutableStateFlow<FullCard?> = MutableStateFlow(null)

    val card = _card.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    fun loadCard(bin: String = "45717360") {

        viewModelScope.launch {
            try {
                _card.value = Common.retrofitService.getCard(bin)
            } catch (e: IOException) {
                Log.d("cvvm", e.message.toString())
            } catch (e: Exception) {
                Log.d("cvvm",e.message.toString())

            }
        }
    }


}