package com.eric.jetpackudemy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eric.jetpackudemy.ui.meals.MealsCategoriesScreen
import com.eric.jetpackudemy.ui.theme.JetpackUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackUdemyTheme {
                MealsCategoriesScreen()
            }
        }
    }
}