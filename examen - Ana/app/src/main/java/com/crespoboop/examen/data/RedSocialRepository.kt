package com.crespoboop.examen.data

import com.crespoboop.examen.main.RedSocial

class RedSocialRepository (private val redsocialDao:RedSocialDao){
    suspend fun getRedesSociales(): List<RedSocial> {
        val entities = redsocialDao.getRedesSociales()
        return entities.map {
            RedSocial(nombre = it.nombre, categoria = it.categoria, valuacion = it.valuacion, descripcion = it.descripcion)
        }
    }

    suspend fun insertRedSocial(redsocial: RedSocial) {
        val entity = RedSocialEntity(nombre = redsocial.nombre, categoria = redsocial.categoria, valuacion = redsocial.valuacion, descripcion = redsocial.descripcion)
        redsocialDao.insertRedSocial(entity)
    }
}