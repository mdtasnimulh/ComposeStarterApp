package com.tasnimulhasan.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tasnimulhasan.database.dao.AppNameDao
import com.tasnimulhasan.entity.room.appname.AppNameEntity

@Database(
    entities = [AppNameEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class AppNameDataBase : RoomDatabase() {
    abstract fun appNameDao(): AppNameDao
}