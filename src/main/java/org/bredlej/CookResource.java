package org.bredlej;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cook")
public class CookResource {

    @Inject
    CookRecipeService cookRecipeService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RecipeResponse cook(IngredientList ingredients) {
        return cookRecipeService.cook(String.join(", ", ingredients.ingredients()));
    }
}
