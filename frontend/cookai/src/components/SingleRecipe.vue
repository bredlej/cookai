<script setup lang="ts">
import { defineProps } from 'vue'
import type SingleRecipe from "@/interfaces/SingleRecipe";
const Props = defineProps<SingleRecipe>()
</script>

<template>
  <div class="card card-normal card-bordered shadow-xl shadow-cyan-500 p-10 my-10">
    <div class="card-title">{{Props.recipe}}</div>
    <div class="card-body">
      <div><strong>Cooking time </strong>{{Props.minutes}} min</div>
      <div><strong>Calories </strong>{{Props.kcal}}</div>
      <h2>Ingredients</h2>
      <ul>
        <li v-for="ingredient in Props.ingredients"><strong>{{ingredient.name}}</strong>: {{ingredient.quantity}}{{ingredient.unit}}</li>
        <li v-for="ingredient in Props.additionalIngredients"><strong>{{ingredient.name}}</strong>: {{ingredient.quantity}}{{ingredient.unit}}</li>
      </ul>
      <h2>Instructions</h2>
      <ul>
        <li v-for="instruction in Props.instructions">{{instruction}}</li>
      </ul>
    </div>
  </div>


</template>

<style scoped>

</style>