package com.crespoboop.examen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crespoboop.examen.data.RedSocialRepository
import kotlinx.coroutines.launch

class RedSocialMainViewModel(private val repository: RedSocialRepository):
    ViewModel() {

    var state by mutableStateOf(RedSocialMainState())
        private set

    init {
        viewModelScope.launch {
            state=state.copy(
                nombres = repository.getRedesSociales()
            )
        }
    }

    fun onNombreChange(nombre: String){
        state=state.copy(
            nombre=nombre
        )
    }

    fun onCategoriaChange(categoria: String){
        state=state.copy(
            categoria = categoria
        )
    }

    fun onValuacionChange(valuacion: String){
        state=state.copy(
            valuacion=valuacion
        )
    }

    fun onDescripcionChange(descripcion: String){
        state=state.copy(
            descripcion = descripcion
        )
    }


    fun saveRedSocial(){
        val redsocial= RedSocial(
            nombre=state.nombre,
            categoria = state.categoria,
            valuacion = state.valuacion,
             descripcion= state.descripcion
        )

        viewModelScope.launch {
            repository.insertRedSocial(redsocial)
        }
    }

}