package jamilligioielli.com.github.gs2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jamilligioielli.com.github.gs2.screens.EquipeScreen
import jamilligioielli.com.github.gs2.screens.IMCScreen
import jamilligioielli.com.github.gs2.screens.LoginScreen
import jamilligioielli.com.github.gs2.screens.MenuScreen
import jamilligioielli.com.github.gs2.ui.theme.GS2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GS2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(
                            route = "imc",
                        ) {
                            IMCScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(
                            route = "equipe",
                        ) {
                            EquipeScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController
                            )
                        }
                    }
                }
            }
        }
    }
}