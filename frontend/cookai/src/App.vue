<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'
</script>

<template>
  <header>
      <nav class="navbar">
        <RouterLink to="/" class="navbar-start">Home</RouterLink>
      </nav>
  </header>
  <div class="container mx-auto">
    <RouterView/>
  </div>
</template>

<style scoped>
</style>
