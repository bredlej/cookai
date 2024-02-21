import type RecipeIngredient from "@/interfaces/RecipeIngredient";

export default interface SingleRecipe {
    recipe: String
    ingredients: RecipeIngredient[],
    additionalIngredients: RecipeIngredient[],
    minutes: number,
    instructions: String[],
    kcal: number
}