package com.sinoptik_.cards.data

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Entity(tableName = "cards")
data class BankCard(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "cardBinNumber") val cardBinNumber: String = "",

    @ColumnInfo(name = "bankName") val bankName: String = "",
    @ColumnInfo(name = "cardType") val cardType: String = "",

    @ColumnInfo(name = "country") val country: String = "",
    @ColumnInfo(name = "latitude") val latitude: String = "",
    @ColumnInfo(name = "longitude") val longitude: String = "",

    @ColumnInfo(name = "url") val url: String = "",
    @ColumnInfo(name = "phone") val phone: String = "",
    @ColumnInfo(name = "city") val city: String = "",

    )
@Dao
interface CardDao{

    @Query("SELECT * FROM cards")
    fun getCards(): Flow<List<BankCard>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(bankCard: BankCard)

    @Query("DELETE FROM cards")
    suspend fun dropAll()


}