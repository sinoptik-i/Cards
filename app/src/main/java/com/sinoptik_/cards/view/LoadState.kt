package com.sinoptik_.cards.view

sealed interface LoadState<out T>

data object UnUsed : LoadState<Nothing>
data object InProgress : LoadState<Nothing>
data class Success<T>(val data: T) : LoadState<T>
data class Failed(val throwable: Throwable) : LoadState<Nothing>
