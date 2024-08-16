<script setup>
  import { RouterView } from 'vue-router';
</script>


<template>
  <RouterView/>
</template>


<style>
html,
body {
  height: 100vh;
  width: 100vw;
  margin: 0;
}

#app {
  height: inherit;
  width: inherit;
  display: flex;
  flex-direction: column;
}
</style>
