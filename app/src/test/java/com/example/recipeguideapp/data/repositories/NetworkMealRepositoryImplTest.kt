package com.example.recipeguideapp.data.repositories

import com.example.recipeguideapp.data.NetworkServiceFactory
import com.example.recipeguideapp.data.datasource.themealdb.ThemealdbApi
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.datasource.themealdb.models.MealsDetail
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import retrofit2.Response
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

internal class NetworkMealRepositoryImplTest {
    private val dataSource = NetworkServiceFactory.getApi("http://themealdb.com/api/json/v1/1/", ThemealdbApi::class.java)
    private val repository = NetworkMealRepositoryImpl(dataSource)

    private fun <T>checkResponseIsCorrect(response: Response<T>, expected: T? = null){
        assertEquals(response.code(), 200)
        assertTrue(response.isSuccessful)
        assertNotNull(response.body())
        expected?.let{assertEquals(response.body(), it)
        }
    }

    @Test
    fun getMealsByName() = runTest {
        val response = repository.getMealsByName("Arrabiata")
        val expected = Gson().fromJson("""
            {
                "meals": [
                    {
                        "idMeal": "52771",
                        "strMeal": "Spicy Arrabiata Penne",
                        "strMealThumb": "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"
                    }
                ]
            }
        """, Meals::class.java)
        checkResponseIsCorrect(response, expected)
    }

    @Test
    fun getAllCategories() = runTest {
        val response = repository.getAllCategories()
        checkResponseIsCorrect(response)

    }

    @Test
    fun getAllAreas() = runTest {
        val response = repository.getAllAreas()
        checkResponseIsCorrect(response)
    }

    @Test
    fun getMealById() = runTest {
        val response = repository.getMealById(52772)
        val expected = Gson().fromJson("""{
            "meals": [
                {
                    "idMeal": "52772",
                    "strMeal": "Teriyaki Chicken Casserole",
                    "strCategory": "Chicken",
                    "strArea": "Japanese",
                    "strInstructions": "Preheat oven to 350° F. Spray a 9x13-inch baking pan with non-stick spray.\r\nCombine soy sauce, ½ cup water, brown sugar, ginger and garlic in a small saucepan and cover. Bring to a boil over medium heat. Remove lid and cook for one minute once boiling.\r\nMeanwhile, stir together the corn starch and 2 tablespoons of water in a separate dish until smooth. Once sauce is boiling, add mixture to the saucepan and stir to combine. Cook until the sauce starts to thicken then remove from heat.\r\nPlace the chicken breasts in the prepared pan. Pour one cup of the sauce over top of chicken. Place chicken in oven and bake 35 minutes or until cooked through. Remove from oven and shred chicken in the dish using two forks.\r\n*Meanwhile, steam or cook the vegetables according to package directions.\r\nAdd the cooked vegetables and rice to the casserole dish with the chicken. Add most of the remaining sauce, reserving a bit to drizzle over the top when serving. Gently toss everything together in the casserole dish until combined. Return to oven and cook 15 minutes. Remove from oven and let stand 5 minutes before serving. Drizzle each serving with remaining sauce. Enjoy!",
                    "strMealThumb": "https://www.themealdb.com/images/media/meals/wvpsxx1468256321.jpg",
                    "strTags": "Meat,Casserole",
                    "strYoutube": "https://www.youtube.com/watch?v=4aZr5hZXP_s",
                    "ingredients": [ "soy sauce", "water", "brown sugar", "ground ginger", "minced garlic", "cornstarch", "chicken breasts","sir-fry vegetables","brown rice"
                    ]
                }
            ]
        }""", MealsDetail::class.java)

        checkResponseIsCorrect(response, expected)
    }

    @Test
    fun filterByCategoryName() = runTest {
        val response = repository.filterByCategoryName("Seafood")
        val expected = Gson().fromJson("""{
    "meals": [
        {
            "strMeal": "Baked salmon with fennel & tomatoes",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/1548772327.jpg",
            "idMeal": "52959"
        },
        {
            "strMeal": "Cajun spiced fish tacos",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg",
            "idMeal": "52819"
        },
        {
            "strMeal": "Escovitch Fish",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/1520084413.jpg",
            "idMeal": "52944"
        },
        {
            "strMeal": "Fish fofos",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/a15wsa1614349126.jpg",
            "idMeal": "53043"
        },
        {
            "strMeal": "Fish pie",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg",
            "idMeal": "52802"
        },
        {
            "strMeal": "Fish Stew with Rouille",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/vptqpw1511798500.jpg",
            "idMeal": "52918"
        },
        {
            "strMeal": "Garides Saganaki",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/wuvryu1468232995.jpg",
            "idMeal": "52764"
        },
        {
            "strMeal": "Grilled Portuguese sardines",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/lpd4wy1614347943.jpg",
            "idMeal": "53041"
        },
        {
            "strMeal": "Honey Teriyaki Salmon",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/xxyupu1468262513.jpg",
            "idMeal": "52773"
        },
        {
            "strMeal": "Kedgeree",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/utxqpt1511639216.jpg",
            "idMeal": "52887"
        },
        {
            "strMeal": "Kung Po Prawns",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/1525873040.jpg",
            "idMeal": "52946"
        },
        {
            "strMeal": "Laksa King Prawn Noodles",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/rvypwy1503069308.jpg",
            "idMeal": "52821"
        },
        {
            "strMeal": "Mediterranean Pasta Salad",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/wvqpwt1468339226.jpg",
            "idMeal": "52777"
        },
        {
            "strMeal": "Mee goreng mamak",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/xquakq1619787532.jpg",
            "idMeal": "53048"
        },
        {
            "strMeal": "Nasi lemak",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/wai9bw1619788844.jpg",
            "idMeal": "53051"
        },
        {
            "strMeal": "Portuguese fish stew (Caldeirada de peixe)",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/do7zps1614349775.jpg",
            "idMeal": "53045"
        },
        {
            "strMeal": "Recheado Masala Fish",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/uwxusv1487344500.jpg",
            "idMeal": "52809"
        },
        {
            "strMeal": "Salmon Avocado Salad",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/1549542994.jpg",
            "idMeal": "52960"
        },
        {
            "strMeal": "Salmon Prawn Risotto",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/xxrxux1503070723.jpg",
            "idMeal": "52823"
        },
        {
            "strMeal": "Saltfish and Ackee",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/vytypy1511883765.jpg",
            "idMeal": "52936"
        },
        {
            "strMeal": "Seafood fideuà",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/wqqvyq1511179730.jpg",
            "idMeal": "52836"
        },
        {
            "strMeal": "Shrimp Chow Fun",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/1529445434.jpg",
            "idMeal": "52953"
        },
        {
            "strMeal": "Sledz w Oleju (Polish Herrings)",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/7ttta31593350374.jpg",
            "idMeal": "53023"
        },
        {
            "strMeal": "Spring onion and prawn empanadas",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/1c5oso1614347493.jpg",
            "idMeal": "53040"
        },
        {
            "strMeal": "Sushi",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/g046bb1663960946.jpg",
            "idMeal": "53065"
        },
        {
            "strMeal": "Three Fish Pie",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/spswqs1511558697.jpg",
            "idMeal": "52882"
        },
        {
            "strMeal": "Tuna and Egg Briks",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/2dsltq1560461468.jpg",
            "idMeal": "52975"
        },
        {
            "strMeal": "Tuna Nicoise",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/yypwwq1511304979.jpg",
            "idMeal": "52852"
        }
    ]
}""", Meals::class.java)
        checkResponseIsCorrect(response, expected)
    }
}