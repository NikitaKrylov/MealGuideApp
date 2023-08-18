package com.example.recipeguideapp

import com.example.recipeguideapp.data.RetrofitServiceFactory
import com.example.recipeguideapp.data.datasource.themealdb.ThemealdbApi
import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import org.junit.Assert.*
import org.junit.Test


class RecipeApiUnitTest {

//    @Test
//    fun testAllMethodsExecuted(){
//        val api = RetrofitServiceFactory.getApi("http://themealdb.com/api/json/v1/1/", ThemealdbApi::class.java)
//        assertEquals(api.getAllCategories().execute().code(), 200)
//        assertEquals(api.getAllCategoriesDetail().execute().code(), 200)
//        val data = api.getRandomRecipe().execute()
//        assertEquals(data.code(), 200)
//        assertNotNull(data.body())
//        assertEquals(api.getMealDetailById(data.body()!!.meals[0].idMeal).execute().code(), 200)
//    }
//
//    @Test
//    fun testGetMeals(){
//        val api = RetrofitServiceFactory.getApi("http://themealdb.com/api/json/v1/1/", ThemealdbApi::class.java)
//        val response = api.getRecipesByMealName("Arrabiata").execute()
//        assertNull(response.errorBody())
//        assertEquals(response.code(), 200)
//        val data = Meals(listOf(
//            MealDetail(
//                52771,
//                "Spicy Arrabiata Penne",
//                "Vegetarian",
//                "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
//                "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
//                "Pasta,Curry",
//                "https://www.youtube.com/watch?v=1IszT_guI08"
//                )
//        ))
//        assertEquals(data, response.body())
//    }




}