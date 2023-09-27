package com.example.tarjetapresentacion
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                TarjetaPresentacionTheme {

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {


                    }
                }
            }
        }
    }

    @Composable
    fun TarjetaPresentacion(name: String, jobTitle: String, company: String, contactInfo: String) {
        // Crear un cuadro para superponer la imagen y el texto
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color(0xFFFFF5E1))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) // Altura de la imagen
                    .background(Color(0xFF000080)) // Cambiar el color a negro azulado según tu preferencia
            ) {
                // Reducir el tamaño de la imagen sin cambiar el espacio que ocupa
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f),
                    alpha = 0.8F
                )
            }
            TarjetaPresentacionText(
                name = name,
                jobTitle = jobTitle,
                company = company,
                contactInfo = contactInfo,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }

    @Composable
    fun TarjetaPresentacionText(
        name: String,
        jobTitle: String,
        company: String,
        contactInfo: String,
        modifier: Modifier = Modifier
    ) {
        // Crear una columna para que los textos no se superpongan
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = jobTitle,
                fontSize = 24.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = company,
                fontSize = 24.sp,
                color = Color.Blue,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = contactInfo,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }

    @Preview(showBackground = false)
    @Composable
    private fun TarjetaPresentacionPreview() {
        TarjetaPresentacionTheme {
            TarjetaPresentacion(
                "Ana Lucas Minalla",
                "Cajera",
                "Stop And Shop",
                "0988343483/alucasminalla@gmail.com"
            )
        }
    }
}
