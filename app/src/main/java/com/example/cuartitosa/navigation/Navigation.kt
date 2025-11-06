package com.example.cuartitosa.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.cuartitosa.screens.*


sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Dash1 : Screen("dash1", "Dash 1", Icons.Default.Home)
    object Dash2 : Screen("dash2", "Dash 2", Icons.Default.Home)
    object Dash3 : Screen("dash3", "Dash 3", Icons.Default.Home)
    object Dash4 : Screen("dash4", "Dash 4", Icons.Default.Home)


    object Detail : Screen("detail/{id}", "Detalle", Icons.Default.Home) {

        fun createRoute(id: Int) = "detail/$id"
    }
}


val bottomBarItems = listOf(
    Screen.Dash1,
    Screen.Dash2,
    Screen.Dash3,
    Screen.Dash4,
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {

            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomBarItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },

                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Dash1.route, // La app empieza en Dash 1
            modifier = Modifier.padding(innerPadding)
        ) {


            composable(Screen.Dash1.route) {
                Dashboard1(navController)
            }


            composable(Screen.Dash2.route) {
                Dashboard2(navController)
            }


            composable(Screen.Dash3.route) {
                Dashboard3(navController)
            }

            // Define la ruta para el Dashboard 4
            composable(Screen.Dash4.route) {
                Dashboard4(navController)
            }


            composable(
                route = Screen.Detail.route, // "detail/{id}"
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->

                val studentId = backStackEntry.arguments?.getInt("id")



                }
            }
        }
    }

