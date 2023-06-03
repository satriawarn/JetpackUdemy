package com.eric.jetpackudemy.ui.meals.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.eric.jetpackudemy.model.MealsRepository
import com.eric.jetpackudemy.model.response.MealsResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()

    var mealState = mutableStateOf<MealsResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>("foodId") ?: ""

        mealState.value = repository.getMeal(mealId)
    }
}