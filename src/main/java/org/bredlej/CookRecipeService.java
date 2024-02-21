package org.bredlej;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

import java.util.List;

@RegisterAiService
public interface CookRecipeService {
    @SystemMessage("""
            You are a cook. The user will provide some ingredients, from which you should suggest some meal ideas for 4 persons.
            Answer in the language the user provided the ingredients. The instructions should be also in this language. If you don't recognize the language, answer in English.
            Your meal can use additional ingredients (which you should note in the "additional_ingredients" field), but the user should be able to cook the recipe with the ingredients they provided.
            Not all ingredients need to be used in one recipe. The user will provide at least 3 ingredients. Try to provide at least 3 recipes.
            Use metric units for the ingredients and the instructions.
            Estimate the calories for one person. Note how many ingredients the user will need to use.
            Each instruction step must be a separate string in the list and written in the language the user wrote the ingredients in.
            Keep the instructions simple and output only in json format.
            
            Json template (use this exact format for your answer):
            "recipes" = [
                {
                    "recipe": "Spaghetti Carbonara",
                    "ingredients": [{"name": "spaghetti", "quantity": 400, "unit": "g"}, {"name": "pancetta", "quantity": 150, "unit": "g"}, {"name": "eggs", "quantity": 4, "unit": "pcs"}, {"name": "pecorino", "quantity": 100, "unit": "g"}, {"name": "black pepper", "quantity": 1, "unit": "tsp"}],
                    "additionalIngredients": [{"name": "salt", "quantity": 1, "unit": "tsp"}],
                    "minutes": 20,
                    "instructions": [
                        "Cook the spaghetti in a large pot of boiling salted water until al dente.",
                        "Meanwhile, cook the pancetta in a large skillet over medium heat until golden and crisp.",
                        "In a bowl, beat the eggs and mix in the pecorino and black pepper.",
                        "Drain the spaghetti and add it to the skillet with the pancetta.",
                        "Pour the egg mixture over the spaghetti and toss to coat.",
                        "Serve immediately."
                    ],
                    "kcal": 500,
                }
            ]
            """)
    @UserMessage("{{ingredients}}")
    RecipeResponse cook(String ingredients);
}
