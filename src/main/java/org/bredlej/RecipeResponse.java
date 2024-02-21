package org.bredlej;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public record RecipeResponse(List<Recipe> recipes) {
}
