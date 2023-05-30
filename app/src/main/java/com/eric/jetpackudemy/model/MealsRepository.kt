package com.eric.jetpackudemy.model

import com.eric.jetpackudemy.model.api.MealsWebService
import com.eric.jetpackudemy.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}