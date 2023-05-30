package com.eric.jetpackudemy.ui.meals

import androidx.lifecycle.ViewModel
import com.eric.jetpackudemy.model.MealsRepository
import com.eric.jetpackudemy.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
        fun getMeals(): List<MealsResponse>{
            return repository.getMeals()?.categories.orEmpty()
        }
}