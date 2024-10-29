package com.tasnimulhasan.data.repoimpl.local

import com.tasnimulhasan.database.dao.AppNameDao
import com.tasnimulhasan.domain.repository.local.AppNameRepository
import com.tasnimulhasan.entity.room.appname.AppNameEntity
import javax.inject.Inject

class AppNameRepoImpl @Inject constructor(
    private val appNameDao: AppNameDao
) : AppNameRepository {

    override suspend fun insertIncomeExpense(appName: AppNameEntity) {

    }
}