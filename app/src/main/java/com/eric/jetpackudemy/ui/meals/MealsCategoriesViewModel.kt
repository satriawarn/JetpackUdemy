package com.eric.jetpackudemy.ui.meals

import androidx.lifecycle.ViewModel
import com.eric.jetpackudemy.model.MealsRepository
import com.eric.jetpackudemy.model.response.MealsCategoriesResponse
import com.eric.jetpackudemy.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}