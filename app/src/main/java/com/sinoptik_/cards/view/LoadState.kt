package com.sinoptik_.cards.view


sealed interface LoadState<out T>

data object UnUsed : LoadState<Nothing>
data object InProgress : LoadState<Nothing>
data class Success<T>(val data: T) : LoadState<T>
data class Failed(val throwable: Throwable) : LoadState<Nothing>



//
//sealed interface LoadState
//
//data object UnUsed : LoadState
//data object InProgress : LoadState
//data class Success(val data: FullCard) : LoadState
//data class Failed(val throwable: Throwable) : LoadState
