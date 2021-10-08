package ru.grokkers.invest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.grokkers.invest.data.db.AppDatabase
import javax.inject.Singleton

/**
 * @author Onanov Aleksey (@onanov)
 */
@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "invest.db")
            .fallbackToDestructiveMigration()
            .build()

}