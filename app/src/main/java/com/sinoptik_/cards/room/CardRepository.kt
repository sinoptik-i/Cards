package com.sinoptik_.cards.room

import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.data.CardDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface CardRepository {
    fun getCardsFlow(): Flow<List<BankCard>>

    suspend fun insertCard(bankCard: BankCard)

    suspend fun dropAll()
}

@Singleton
class CardRepositoryImpl @Inject constructor(
    val dao: CardDao
) : CardRepository {
    override fun getCardsFlow(): Flow<List<BankCard>> = dao.getCards()

    override suspend fun insertCard(bankCard: BankCard) = dao.insertCard(bankCard)

    override  suspend fun dropAll()=dao.dropAll()

}