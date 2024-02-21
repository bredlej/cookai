<script setup lang="ts">

import EnterIngredients from "@/components/EnterIngredients.vue";
import {recipesStore} from "@/stores/recipesStore";
import SingleRecipe from "@/components/SingleRecipe.vue";
import {ref} from "vue";
const store = recipesStore();
const loading = ref(false);

async function searchRecipes(ingredients: String) {
  loading.value = true;
  const requestOptions = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ingredients: ingredients.split(',')})
  };

  fetch('http://localhost:8080/cook', requestOptions)
    .then(response => response.json())
    .then(data => {
      store.setRecipes(data.recipes);
      loading.value = false;
    })
    .catch(error => {
      console.log('error', error);
      loading.value = false;
    });
}
</script>

<template>
  <main>
    <div>
      <EnterIngredients @ingredientsSubmitted="searchRecipes"/>
    </div>
    <div v-if="loading" class="loading">Please wait...</div>
    <div v-else class="card">
      <SingleRecipe v-for="singleRecipe in store.recipes"
                    :key="singleRecipe.recipe"
                    :recipe="singleRecipe.recipe"
                    :instructions="singleRecipe.instructions"
                    :kcal="singleRecipe.kcal"
                    :additional-ingredients="singleRecipe.additionalIngredients"
                    :minutes="singleRecipe.minutes"
                    :ingredients="singleRecipe.ingredients" />
    </div>

  </main>
</template>

<style scoped>

</style>