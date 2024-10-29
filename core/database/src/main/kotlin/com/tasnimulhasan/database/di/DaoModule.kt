package com.tasnimulhasan.database.di

import com.tasnimulhasan.database.AppNameDataBase
import com.tasnimulhasan.database.dao.AppNameDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun providesIncomeExpenseDao(
        database: AppNameDataBase
    ): AppNameDao = database.appNameDao()

}