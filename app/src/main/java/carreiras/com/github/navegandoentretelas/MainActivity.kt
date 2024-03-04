package carreiras.com.github.navegandoentretelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                        composable("perfil") { PerfilScreen(navController) }
                        composable("pedidos") { PedidosScreen(navController) }
                    }
                }
            }
        }
    }
}
