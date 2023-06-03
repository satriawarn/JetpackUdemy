package com.eric.jetpackudemy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eric.jetpackudemy.ui.meals.MealsCategoriesScreen
import com.eric.jetpackudemy.ui.meals.details.MealDetailScreen
import com.eric.jetpackudemy.ui.meals.details.MealDetailsViewModel
import com.eric.jetpackudemy.ui.theme.JetpackUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackUdemyTheme {
                MealzApp()
            }
        }
    }
}

@Composable
private fun MealzApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "meals_list") {
        composable(route = "meals_list") {
            MealsCategoriesScreen { navigationMealId ->
                navController.navigate("meals_detail/$navigationMealId")
            }
        }
        composable(
            route = "meals_detail/{foodId}",
            arguments = listOf(navArgument("foodId") {
                type = NavType.StringType
            })
        ) {
            val viewModel : MealDetailsViewModel = viewModel()
            MealDetailScreen(viewModel.mealState.value)
        }
    }
}