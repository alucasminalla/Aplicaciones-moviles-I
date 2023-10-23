package com.crespoboop.examen.main

data class RedSocialMainState(
    val nombre: String="",
    val categoria: String="",
    val valuacion: String="",
    val descripcion: String="",
    val nombres: List<RedSocial> = emptyList()
)
