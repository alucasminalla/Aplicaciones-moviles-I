package com.crespoboop.examen.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RedSocialEntity::class], version = 1)
abstract class RedSocialDatabase: RoomDatabase() {

    abstract val dao:RedSocialDao
}