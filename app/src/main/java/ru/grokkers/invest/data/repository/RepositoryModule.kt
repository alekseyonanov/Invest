package ru.grokkers.invest.data.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import ru.grokkers.invest.data.repository.impl.EducationRepositoryImpl
import ru.grokkers.invest.data.repository.impl.StockRepositoryImpl
import ru.grokkers.invest.data.repository.impl.UserRepositoryImpl

/**
 * @author Onanov Aleksey (@onanov)
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun userRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun stockRepository(repository: StockRepositoryImpl): StockRepository

    @Binds
    abstract fun educationRepository(repository: EducationRepositoryImpl): EducationRepository

}