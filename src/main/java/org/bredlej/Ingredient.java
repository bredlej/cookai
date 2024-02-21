package org.bredlej;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record Ingredient(String name, double quantity, String unit) {
}
