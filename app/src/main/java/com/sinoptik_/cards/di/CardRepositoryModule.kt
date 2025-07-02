package com.sinoptik_.cards.di

import android.content.Context
import com.sinoptik_.cards.data.CardDao
import com.sinoptik_.cards.room.CardDb
import com.sinoptik_.cards.room.CardRepository
import com.sinoptik_.cards.room.CardRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CardRepositoryModule {
    @Provides
    fun providesCardDao(
        @ApplicationContext context: Context
    ): CardDao = CardDb.getDatabase(context).dao()

    @Provides
    fun providesCardRepo(impl: CardRepositoryImpl): CardRepository = impl
}