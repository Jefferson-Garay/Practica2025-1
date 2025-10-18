package dev.jeff.practica2025_1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.jeff.practica2025_1.presentation.menu.MenuScreen
import dev.jeff.practica2025_1.presentation.dogage.DogAgeScreen
import dev.jeff.practica2025_1.presentation.currency.CurrencyConverterScreen
import dev.jeff.practica2025_1.presentation.catalog.ProductCatalogScreen

object Routes {
    const val MENU = "menu"
    const val DOGAGE = "dogage"
    const val CURRENCY = "currency"
    const val CATALOG = "catalog"
}

@Composable
fun AppNavGraph(startDestination: String = Routes.MENU) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.MENU) {
            MenuScreen(
                onGoToDogAge = { navController.navigate(Routes.DOGAGE) },
                onGoToCurrency = { navController.navigate(Routes.CURRENCY) },
                onGoToCatalog = { navController.navigate(Routes.CATALOG) }
            )
        }

        composable(Routes.DOGAGE) {
            DogAgeScreen(
                onBackToMenu = {
                    navController.navigate(Routes.MENU) {
                        popUpTo(Routes.MENU) { inclusive = false }
                    }
                }
            )
        }

        composable(Routes.CURRENCY) {
            CurrencyConverterScreen(
                onBackToMenu = {
                    navController.navigate(Routes.MENU) {
                        popUpTo(Routes.MENU) { inclusive = false }
                    }
                }
            )
        }

        composable(Routes.CATALOG) {
            ProductCatalogScreen(
                onBackToMenu = {
                    navController.navigate(Routes.MENU) {
                        popUpTo(Routes.MENU) { inclusive = false }
                    }
                }
            )
        }
    }
}

@Composable
fun ProductCatalogScreen(onBackToMenu: () -> Unit) {
    TODO("Not yet implemented")
}

@Composable
fun CurrencyConverterScreen(onBackToMenu: () -> Unit) {
    TODO("Not yet implemented")
}
