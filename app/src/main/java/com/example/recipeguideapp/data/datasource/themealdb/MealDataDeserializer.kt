package com.example.recipeguideapp.data.datasource.themealdb

import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class MealDataDeserializer : JsonDeserializer<MealDetail> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): MealDetail {
        val data = json.asJsonObject
        val ingredients = mutableListOf<String>()
        val measures = mutableListOf<String>()

        for (i in 1..20){
            data.get("strIngredient$i")?.let {
                if (!it.isJsonNull && it.asString.isNotEmpty())
                    ingredients.add(it.asString)
            }
        }
        for (i in 1..20){
            data.get("strMeasure$i")?.let {
                if (!it.isJsonNull && it.asString.isNotEmpty())
                    measures.add(it.asString)
            }
        }
        return MealDetail(
            json.asJsonObject.get("idMeal").asInt,
            json.asJsonObject.get("strMeal").asString,
            json.asJsonObject.get("strCategory").asString,
            json.asJsonObject.get("strInstructions").asString,
            json.asJsonObject.get("strMealThumb").asString,
            "",
            json.asJsonObject.get("strYoutube").asString,
            ingredients,
            measures
        )
    }
}