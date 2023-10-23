package com.crespoboop.examen.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RedSocialEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nombre: String,
    val categoria: String,
    val valuacion: String,
    val descripcion: String,

)

