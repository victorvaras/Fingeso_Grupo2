<template>

  <div class="property-detail">
    <button class="back-button" @click="goBack">Volver al menú</button>
  </div>
    <div class="box-property">
      <div class="property-container">
        <img :src="property.imagenes" alt="Imagen de la propiedad" class="property-image" />
        <div class="property-info">
          <h1>Casa {{ property.tipo }}</h1>
          <p>Tamaño: {{ property.tamano }}</p>
          <p>Descripción: {{ property.descripcion }}</p>
          <p>Precio: ${{ property.precio }}</p>
          <p>Estado: {{ property.idEstado || 'No disponible' }}</p>
          <button
              class="action-button"
              :class="{
              'rent': property.idEstado === 'arrendar',
              'buy': property.idEstado === 'comprar',
              'reserve': !property.idEstado
            }"
          >
            {{ buttonText }}
          </button>
        </div>
    </div>
  </div>
  <footer>
    <p>&copy; 2024 Hogar a un Click.</p>
    <p><a href="#contact">Contáctanos</a> | <a href="#help">Ayuda</a></p>
  </footer>
</template>

<script>
import axios from "axios";

export default {
  props: ['id'], // props debe ser true en la configuracion del router

  data() {
    return {
      property: [],
      buttonText: ''
    };
  },

  mounted() {
    this.fetchPropiedad();
    this.updateButtonText();
  },
  methods: {
    async fetchPropiedad() {
      try {
        const response = await axios.get(import.meta.env.VITE_BASE_URL + `propiedad/${this.id}`);
        this.property = response.data;
      } catch (error) {
        console.error('Error al obtener las propiedades:', error);
        alert('No se pudieron cargar las propiedades.');
      }
    },
    updateButtonText() {
      if (this.property.idEstado === 'arrendar') {
        this.buttonText = 'Arrendar';
      } else if (this.property.idEstado === 'comprar') {
        this.buttonText = 'Comprar';
      } else {
        this.buttonText = 'Reservar';
      }
    },
    goBack() {
      this.$router.push('/user');
    }
  }
};
</script>

<style scoped>

.box-property {
  background-color: #e0bbac;
  color: #2f1f1c;
  padding: 50px;
  height: 100%;
}

.property-detail {
  background-color: #d0886d;
  padding: 20px;
}

.back-button {
  background-color: rgba(253, 246, 250, 0.98);
  border: none;
  padding: 10px;
  cursor: pointer;
  margin-bottom: 0px;
  margin-left: 10px;
}

.property-container {
  display: flex;
  align-items: flex-start;
  width: 100%; /* Use full width */
  max-width: 1200px; /* Optionally limit the maximum width */
  margin: 0; /* Center within the parent */

}

.property-image {
  width: 800px;
  height: auto;
  margin-right: 50px;
  border-radius: 10px;
}

.property-info {
  flex: 1;
}

.action-button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s;
}

.action-button.rent {
  background-color: #4caf50;
  color: white;
}

.action-button.buy {
  background-color: #2196f3;
  color: white;
}

.action-button.reserve {
  background-color: #ff9800;
  color: white;
}

.action-button:hover {
  opacity: 0.8;
}

footer {
  background-color: #333;
  color: #fff;
  text-align: center;
  padding: 10px 0;
  font-size: 14px;
  margin-top: auto;
}

footer a {
  color: #fff;
  text-decoration: none;
  margin: 0 5px;
}

footer a:hover {
  text-decoration: underline;
}

</style>