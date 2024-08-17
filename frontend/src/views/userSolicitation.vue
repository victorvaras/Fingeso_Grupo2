<template>
    <div class="portal-usuario">
      <header>
        <h1 class="userHeader">Portal Usuario</h1>
        <nav>
          <ul>
            <li><a href="#home">Inicio</a></li>
            <li><a href="#properties">Propiedades</a></li>
            <li><a href="#perfil">Mi perfil</a></li>
            <span class="username">{{ username }}</span>
          </ul>
        </nav>
      </header>
      <section class="Boton-subir-propiedad">
            <router-link to= "/SubirPropiedad"> 
                <div class = "SubirPropiedad" @click="handleChange"> Subir propiedad</div>
            </router-link> >
        </section>
      <section class="home">
            <h1>Propiedades Ideales</h1>
            <p>Explora las propiedades ideales que hay para ti</p>
            <section id="properties" class="properties">
                <div class="card-container">
                    <!-- Usamos v-for para iterar sobre la lista de propiedades -->
                    <div class="card" v-for="(property, index) in properties" :key="index">
                        <img :src="property.imagenes" :alt="'Imagen propiedad ' + (index + 1)">
                        <div class="card-content">
                            <h3>{{ property.tipo }}</h3>
                            <p>{{ property.descripcion }}</p>
                            <p>Precio: {{ property.precio }}</p>
                            <button>Ver más detalles</button>
                        </div>
                    </div>
                </div>
            </section>
        </section>
      <footer>
        <p>&copy; 2024 Hogar a un Click.</p>
        <p><a href="#contact">Contáctanos</a> | <a href="#help">Ayuda</a></p>
      </footer>
    </div>
  </template>
  
<script>

import axios from 'axios';

  export default {
    data() {
      return {
        username: "",
        properties: []
      };
    },
    mounted() { //Es lo promero que se carga 
      // Recupera el nombre de usuario de localStorage
      const storedUsername = localStorage.getItem("login");
      if (storedUsername) {
        this.username = JSON.parse(storedUsername);
      }
      this.fetchProperties();
    },
    methods: {
    async fetchProperties() {
        try {
            const response = await axios.get(import.meta.env.VITE_BASE_URL + "propiedad");
            this.properties = response.data;
        } catch (error) {
            console.error('Error al obtener las propiedades:', error);
            alert('No se pudieron cargar las propiedades.');
        }
        }
    }
  };
  </script>


<style scoped>


body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.username{
    color: black;
}

.portal-usuario {
    text-align: center;
    width: 100%;
}

.userHeader {
    text-align: left;

}

header {
    background-color: rgb(106, 120, 115);
    color: aliceblue;
    padding: 30px;

}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    margin-top: 20px;
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
    /*transition: 0.3s;*/
}

.home {
    color: rgb(255, 255, 255);
    background-color: rgb(115, 128, 139);
    padding: 50px 0;
}

.home h1 {
    font-size: 2.5em;
}

.properties {
    color: rgb(255, 255, 255);
    padding: 50px 0;
}

.card-container {
    display: grid;
    flex-wrap: wrap;
    justify-content: space-around;
    color: black;
    grid-template-columns: repeat(3, 1fr); /* Tres columnas de igual tamaño */
    gap: 20px; 
}

.card {
    background-color: rgb(197, 162, 117);
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
    max-width: 100%;
    height: auto;
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
    margin: o.5em 0;
}

.card-content button {
    background-color: rgb(136, 113, 54);
    border: none;
    border-radius: 4px;
    color: white;
    cursor: pointer;
    padding: 10px;
    width: 100%;
}

.card-content button:hover {
    background-color: rgb(91, 74, 30);
}

footer {
    background-color: #333;
    color: #fff;
    text-align: center;
    padding: 10px 0;
    font-size: 14px;
  }
  
  footer a {
    color: #fff;
    text-decoration: none;
    margin: 0 5px;
  }
  
  footer a:hover {
    text-decoration: underline;
  }

.Boton-subir-propiedad{
    text-align: right; /* Alinea el contenido a la derecha */
}

</style>