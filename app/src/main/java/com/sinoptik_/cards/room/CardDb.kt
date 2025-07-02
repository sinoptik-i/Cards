package com.sinoptik_.cards.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sinoptik_.cards.data.BankCard
import com.sinoptik_.cards.data.CardDao

@Database(
    entities = [BankCard::class],
    version = 1,
    exportSchema = true
)
abstract class CardDb : RoomDatabase() {

    abstract fun dao(): CardDao

    companion object {
        private var INSTANCE: CardDb? = null
        fun getDatabase(context: Context): CardDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    CardDb::class.java,
                    "card_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}