package com.tasnimulhasan.domain.repository.local

import com.tasnimulhasan.entity.room.appname.AppNameEntity

interface AppNameRepository {
    suspend fun insertIncomeExpense(appName: AppNameEntity)
}