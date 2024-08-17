<template>
  <!-- Todas las class que se declaran es para poder trabajar mas comodamente con los css -->
  <div class="portal-usuario">
    <header>
      <h1 class="userHeader">Portal Usuario</h1>
      <nav>
        <ul>
          <li><a href="#home">Inicio</a></li>
          <li><a href="#properties">Propiedades</a></li>
          <li><a href="#contact">Contacto</a></li>
          <span class="username">{{ username }}</span>
        </ul>
      </nav>
    </header>

    

  <div> 
    <section class="home">
      <div  class="TextoPropiedades"> 
        <h1>Propiedades Ideales</h1>
        <!-- Parrafo-->
        <p>Explora las propiedades ideales que hay para ti</p>
      </div>

      <div class="ApartadoBoton">
        <section v-if="!isGuest" class="Boton-subir-propiedad">
          <router-link to= "/SubirPropiedad">
            <div class = "SubirPropiedad" @click="handleChange"> Subir propiedad</div>
          </router-link> >
        </section>
      </div>
    
    </section>

    
  </div>

    <!-- Dado el id cuando se presione properties te manda a esta seccion -->
    <section id="properties" class="properties">
      <h1>Propiedades Disponibles</h1>
      <div class="menu-propiedades">
        <div class="card-container">
          <div v-for="(casa, index) in paginaCasas" :key="casa.id" class="card">
            <!-- Esto ocupa una sintaxis literal de texto para evaluarse con :src y comillas -->
            <img :src="casa.imagenes" :alt="'Imagen propiedad ' + (index + 1)">
            <div class="card-content">
              <h3>{{ casa.tipo }}</h3>
              <p>{{ casa.descripcion }}</p>
              <p>Valoracion: {{ casa.valoracion }}</p>
              <p>Precio: {{ casa.precio }}</p>
              <button @click="verPropiedad(casa.rol)">Ver más detalles</button>
            </div>
          </div>
        </div>
      </div>
      <div  class="pagination-controls">
        <button @click="prevPage" :disabled="currentPage===1">Anterior</button>
        <span class="botones-siguiente"> {{currentPage}} de {{totalPages}} </span>
        <button  @click="nextPage" :disabled="currentPage === totalPages">Siguiente</button>
      </div>
    </section>
  </div>
  <footer>
    <p>&copy; 2024 Hogar a un Click.</p>
    <p><a href="#contact">Contáctanos</a> | <a href="#help">Ayuda</a></p>
  </footer>

</template>

<script>

import axios from "axios";

export default {
  data() {
    return {
      username: "",
      properties: [],
      currentPage: 1,
      itemsPerPage:6,
      isGuest: false,
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.properties.length / this.itemsPerPage);
    },
    paginaCasas() {
      const start = (this.currentPage - 1) * this.itemsPerPage;
      const end = start + this.itemsPerPage;
      return this.properties.slice(start, end);
    },
  },
  mounted() {
    // Recupera el nombre de usuario de localStorage
    const storedUsername = localStorage.getItem("login");
    if (storedUsername) {
      this.username = JSON.parse(storedUsername);
    } else{
      // If no username is found, assume the user is a guest
      this.isGuest = true;
    }
    //Encuentra las casas
    this.fetchPropiedades();
  },
  methods: {
    async fetchPropiedades() {
      try {
        const response = await axios.get(import.meta.env.VITE_BASE_URL + "propiedad");
        this.properties = response.data;
      } catch (error) {
        console.error('Error al obtener las propiedades:', error);
        alert('No se pudieron cargar las propiedades.');
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
      }
    },
    prevPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    verPropiedad(id) {
      // Aqui dependiendo del boton que se clickee con una id, se hara ruta a mostrar los datos de esa id
      this.$router.push({ name: 'propiedad', params: { id:id } });
    },
  },
};

</script>

<style scoped>

.botones-siguiente{
  color: #2b1515;
  margin-left: 10px;
  margin-right: 10px;
}

.TextoPropiedades {
  text-align: center;
  flex: 1;
}


body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

.portal-usuario {
  text-align: center;
}

header {
  background-color: rgb(106, 120, 115);
  color: aliceblue;
  padding: 40px;
}

nav ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  margin-top: auto;
}

nav ul li {
  display: inline;
  margin: 0 15px;
}

nav ul li a {
  background-color: rgb(80, 141, 155);
  border: none;
  border-radius: 10px;
  color: aliceblue;
  cursor: pointer;
  padding: 10px 20px;
  text-decoration: none;
  transition: background-color 0.2s;

  /*transition: 0.3s;*/
}

.home {
  color: rgb(255, 255, 255);
  background-color: rgb(115, 128, 139);
  padding: 50px 0;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.home h1 {
  font-size: 2.5em;
}

.properties {
  color: rgb(255, 255, 255);
  padding: 50px 0;
  background-color: antiquewhite;
}

.properties h1{
  color: #333;
}

.card-container {
  display: flex;

  flex-wrap: wrap;
  justify-content: space-around;
  color: black;
}

.card {
  background-color: rgb(241, 180, 99);
  border: 1px solid rgb(255, 255, 255);
  border-radius: 10px;
  box-shadow: 0 4px 8px black;
  margin: 20px;
  max-width: 300px;
  overflow: hidden;
  transition: transform 0.3s;
}

.card hover {
  transform: scale(1.1);
}

.card img {
  border-radius: 8px 8px 0 0;
  width: 300px;
  height: 200px;
}

.card content {
  color: black;
  padding: 15px;
}

.card-content h3 {
  font-size: 1.5em;
  margin: 0.5em 0;
}

.card-content p {
  margin: 0.5em 0;
}

.card-content button {
  background-color: #f0c0ab;
  border: none;
  border-radius: 4px;
  color: #2b1515;
  cursor: pointer;
  padding: 10px;
  width: 100%;
}

.card-content button:hover {
  background-color: #e5a388;
}
.pagination-controls{
  margin-top: 20px;
}



.menu-propiedades {
  background-color: #efd7cd;
  border: 2px solid rgb(0, 0, 0);
  border-radius: 20px;
}

.userHeader {
  text-align: left;
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

.Boton-subir-propiedad {

  background-color: #4e657a; /* Color de fondo verde */
  color: white; /* Color del texto blanco */
  border: none; /* Sin borde */
  padding: 10px 20px; /* Espaciado interno */
  text-align: center; /* Alineación del texto */
  text-decoration: none; /* Sin subrayado */
  display: inline-block; /* Alineación en línea */
  font-size: 16px; /* Tamaño de la fuente */
  margin: 4px 2px; /* Margen alrededor del botón */
  cursor: pointer; /* Cambia el cursor al pasar sobre el botón */
  border-radius: 4px; /* Bordes redondeados */

}

.ApartadoBoton{
  text-align: right;
  display: flex;
  margin-right: 50px;

}

.SubirPropiedad{
  color: white;
}


</style>