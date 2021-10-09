package ru.grokkers.invest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.grokkers.invest.data.db.AppDatabase
import javax.inject.Singleton

/**
 * @author Onanov Aleksey (@onanov)
 */
@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "invest.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun userDao(appDatabase: AppDatabase) = appDatabase.userDao()

    @Provides
    fun stockDao(appDatabase: AppDatabase) = appDatabase.stockDao()

}