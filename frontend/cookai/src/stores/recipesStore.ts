import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import type SingleRecipe from "@/interfaces/SingleRecipe";

export const recipesStore = defineStore('recipes', () => {
    const recipes = ref<SingleRecipe[]>([])
    const selectedRecipe = ref<SingleRecipe>({"recipe": "", "ingredients": [], "additionalIngredients": [], "minutes": 0, "instructions": [], "kcal": 0})
    const selectedRecipeIndex = ref(-1)

    function setRecipes(newRecipes: SingleRecipe[]) {
        recipes.value = newRecipes
    }

    function setSelectedRecipe(recipe: SingleRecipe) {
        selectedRecipe.value = recipe
        selectedRecipeIndex.value = recipes.value.indexOf(recipe)
    }

    function nextRecipe() {
        if (selectedRecipeIndex.value < recipes.value.length - 1) {
        selectedRecipeIndex.value++
        selectedRecipe.value = recipes.value[selectedRecipeIndex.value]
        }
    }

    function previousRecipe() {
        if (selectedRecipeIndex.value > 0) {
        selectedRecipeIndex.value--
        selectedRecipe.value = recipes.value[selectedRecipeIndex.value]
        }
    }

    const selectedRecipeIngredients = computed(() => {
        return selectedRecipe.value ? selectedRecipe.value.ingredients : []
    })

    return {
        recipes,
        selectedRecipe,
        setRecipes,
        setSelectedRecipe,
        nextRecipe,
        previousRecipe,
        selectedRecipeIngredients
    }
})