package com.tasnimulhasan.appname.di

import com.tasnimulhasan.data.repoimpl.local.AppNameRepoImpl
import com.tasnimulhasan.domain.repository.local.AppNameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindIncomeExpenseRepository(incomeExpenseRepoImpl: AppNameRepoImpl): AppNameRepository
}