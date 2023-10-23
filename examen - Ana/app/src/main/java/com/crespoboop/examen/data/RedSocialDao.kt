package com.crespoboop.examen.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface RedSocialDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertRedSocial(redsocial:RedSocialEntity)

    @Query("SELECT * FROM RedSocialEntity")
    suspend fun getRedesSociales():List<RedSocialEntity>
}


