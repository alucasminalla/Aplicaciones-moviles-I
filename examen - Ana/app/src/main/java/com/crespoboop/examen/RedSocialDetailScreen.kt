package com.crespoboop.examen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController, texto:String?,
                 texto2: String?, texto3:String?, texto4: String?){
    //  val state=viewModel.state
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center

        ) {

            Text(
                text = "Nombre: ${texto}",
                style = MaterialTheme.typography.h6
            )
            //Spacer(modifier = Modifier.padding(12.dp))
            Text(
                text = "Categoria: ${texto2}",
                style = MaterialTheme.typography.h6
            )

            Text(
                text = "Valuación: ${texto3}",
                style = MaterialTheme.typography.h6
            )

            Text(
                text = "Descripción: ${texto4}",
                style = MaterialTheme.typography.h6
            )


        }
    }
}