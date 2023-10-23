package com.crespoboop.examen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, viewModel: RedSocialMainViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Ingreso de datos")})
        }
    ) {padding ->

        val state = viewModel.state
        Column(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Nombre: Ana Lucas Minalla ")
            Text(text = "Entidad: Red Social")
            Text(text = "Curso: 7A")
            OutlinedTextField(value = state.nombre, onValueChange = { viewModel.onNombreChange(it) },
                placeholder = { Text("Nombre de la red social") })
            OutlinedTextField(value = state.categoria, onValueChange = { viewModel.onCategoriaChange(it) },
                placeholder = { Text("Categoria de la red social") })
            OutlinedTextField(value = state.valuacion, onValueChange = {viewModel.onValuacionChange(it)},
                placeholder = { Text("Valuación") })
            OutlinedTextField(value = state.descripcion, onValueChange = {viewModel.onDescripcionChange(it)},
                placeholder = { Text("Descripción de la red social") })
            Button(onClick = { viewModel.saveRedSocial() }) {
                Text(text = "Crear", fontSize = 18.sp)
            }

            Button(onClick = { navController.navigate("lista") }) {
                Text(text = "ver lista")
            }
        }
    }
}