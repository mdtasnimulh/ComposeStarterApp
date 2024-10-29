package com.tasnimulhasan.entity.room.appname

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_name_table")
data class AppNameEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
)