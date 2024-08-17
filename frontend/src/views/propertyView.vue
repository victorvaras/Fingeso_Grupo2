<template>
  <div>
    <h1>[Direccion casa o datos]</h1>
    <p>Propiedad ID: {{ id }}, con esto se puede obtener los datos con un GET</p>
  </div>
</template>

<script>
export default {
  props: ['id'], // If you use props: true in the router configuration

  // If not using props: true, use this.$route.params.id
  computed: {
    id() {
      return this.$route.params.id;
    },
  },

  mounted() {
    // Fetch property details based on ID
    console.log('Fetching details for property with ID:', this.id);
    // Example: axios.get(`http://localhost:3000/api/properties/${this.id}`)
  },
};
</script>