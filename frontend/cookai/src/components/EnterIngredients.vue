<script setup lang="ts">
import {ref} from "vue";
let ingredients = ref('');
defineEmits({
  ingredientsSubmitted: (val: String) => true
});
</script>

<template>
  Enter some ingredients:
  <input v-model="ingredients" class="input input-primary">
  <button @click="ingredients = ''" class="btn btn-secondary">Clear</button>
  <button @click="$emit('ingredientsSubmitted', ingredients)" class="btn btn-primary">Submit</button>
</template>
<style scoped>

</style>