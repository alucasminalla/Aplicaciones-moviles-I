package com.crespoboop.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.crespoboop.examen.data.RedSocialDatabase
import com.crespoboop.examen.data.RedSocialRepository
import com.crespoboop.examen.main.MainScreen
import com.crespoboop.examen.main.RedSocialMainViewModel
import com.crespoboop.examen.main.RedSocialScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db= Room.databaseBuilder(this, RedSocialDatabase::class.java, "RedSocialDb").build()
        val dao= db.dao
        val repository= RedSocialRepository(dao)
        val viewmodel = RedSocialMainViewModel(repository)

        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "main" ){
                composable("main" ){

                    MainScreen(navController,viewmodel)

                }
                composable(route="detail"+"/{text}/{text2}/{text3}/{text4}",
                    arguments =  listOf(navArgument(name = "text") {type= NavType.StringType }, (navArgument(name="text2") { type= NavType.StringType }),
                    (navArgument(name="text3"){
                        type= NavType.StringType }
                            ),
                    (navArgument(name="text4"){
                        type= NavType.StringType }
                            )
                )
                )
                {
                    DetailScreen(navController, it.arguments?.getString("text"),
                        it.arguments?.getString("text2"), it.arguments?.getString("text3"), it.arguments?.getString("text4"))
                }

                composable("lista"){
                    RedSocialScreen(viewModel = viewmodel, navController =navController )
                }
            }
        }
    }
}