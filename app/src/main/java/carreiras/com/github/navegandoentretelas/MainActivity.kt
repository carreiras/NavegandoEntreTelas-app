package carreiras.com.github.navegandoentretelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import carreiras.com.github.navegandoentretelas.screens.LoginScreen
import carreiras.com.github.navegandoentretelas.screens.MenuScreen
import carreiras.com.github.navegandoentretelas.screens.PedidosScreen
import carreiras.com.github.navegandoentretelas.screens.PerfilScreen
import carreiras.com.github.navegandoentretelas.ui.theme.NavegandoEntreTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegandoEntreTelasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") { LoginScreen(navController) }
                        composable("menu") { MenuScreen(navController) }
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome") {
                                    type = NavType.StringType
                                },
                                navArgument("idade") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val nome: String? =
                                it.arguments?.getString("nome", "")
                            val idade: Int? =
                                it.arguments?.getInt("idade", 0)
                            PerfilScreen(navController, nome!!, idade!!)
                        }
                        composable(
                            route = "pedidos?cliente={cliente}",
                            arguments = listOf(navArgument(name = "cliente") {
                                defaultValue = "Sem cliente"
                            })
                        ) {
                            PedidosScreen(navController, it.arguments?.getString("cliente"))
                        }
                    }
                }
            }
        }
    }
}
