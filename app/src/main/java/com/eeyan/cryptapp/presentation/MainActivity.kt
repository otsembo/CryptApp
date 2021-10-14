package com.eeyan.cryptapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eeyan.cryptapp.presentation.coin_detail.CoinDetailScreen
import com.eeyan.cryptapp.presentation.coin_list.CoinListScreen
import com.eeyan.cryptapp.presentation.theme.CryptAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptAppTheme {
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.CoinListScreen.route){

                        composable(
                            route = Screen.CoinListScreen.route
                        ){

                            CoinListScreen(navController = navController)

                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ){
                            CoinDetailScreen()
                        }

                    }

                }
            }
        }
    }
}

