package ru.grokkers.invest.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

/**
 * @author Onanov Aleksey (@onanov)
 */
@Module
@InstallIn(ViewModelComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "invest.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun userDao(appDatabase: AppDatabase) = appDatabase.userDao()

    @Provides
    fun stockDao(appDatabase: AppDatabase) = appDatabase.stockDao()

}