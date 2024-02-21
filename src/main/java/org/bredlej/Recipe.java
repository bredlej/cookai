package org.bredlej;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public record Recipe(String recipe, List<Ingredient> ingredients, List<Ingredient> additionalIngredients, int minutes, List<String> instructions, int kcal) {
}
