package com.crespoboop.examen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun RedSocialScreen(viewModel: RedSocialMainViewModel, navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Consulta de los registros") }
        )
    }) { padding ->
        val state = viewModel.state

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(state.nombres) { item ->
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("detail/${item.nombre}/${item.categoria}/${item.valuacion}/${item.descripcion}")
                        }
                        .fillMaxWidth()
                        .background(color = Color.DarkGray)
                        .padding(horizontal = 15.dp, vertical = 8.dp)
                ) {
                    Text(text = "Nombre: ${item.nombre}", color = Color.White)
                    Text(text = "Categoria:  ${item.categoria}", color = Color.White)
                    Text(text = "Valuación: ${item.valuacion}", color = Color.White)
                    Text(text = "Descripción: ${item.descripcion}", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(12.dp))
            }
        }
    }
}