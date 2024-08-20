<template>
  <div class="full-pantalla">
    
   
    <div class="property-detail">
      <div class="title-container">
        <h1>Subir Propiedad</h1>
      </div>
      <button class="back-button" @click="goBack">Volver al Menú</button>
    </div>

    <div class= "fondo">

      <section class="subir-propiedad">
        <h2 style="color: black">Formulario para Subir Propiedad</h2>
        <form id="propertyForm" @submit.prevent="subirNewPropiedad">
          <div class="form-group">
            
            <input type="number" placeholder="ROL de la Propiedad" v-model="propiedadRol" required>
          </div>
          <div class="form-group">
            
            <input type="text" placeholder="Tipo de Propiedad" v-model="propiedadTipo" required>
          </div>
          <div class="form-group">
            
            <input type="number" placeholder="Tamaño de la Propiedad" v-model="propiedadTamano" required>
          </div>
          <div class="form-group">
            
            <input type="text" placeholder="Ubicación Propiedad" v-model="propiedadUbicacion" required>
          </div>
          <div class="form-group">
            
            <input type="number" placeholder="Precio Propiedad" v-model="propiedadPrecio" required>
          </div>
          <div class="form-group">
            
            <input type="text" placeholder="Imagen de la Propiedad (URL de Imagen)" v-model="propiedadImagen" required>
          </div>
          <div class="form-group">
            
            <input type="text" placeholder="Descripción de la Propiedad" v-model="propiedadDescripcion" required>
          </div>
          <button type="submit">Subir Propiedad</button>
        </form>
      </section>

    </div>
  

    <footer>
      <p>&copy; 2024 Hogar a un Click.</p>
      <p><a href="#contact">Contáctanos</a> | <a href="#help">Ayuda</a></p>
    </footer>
  </div>
</template>

<script>
import axios from 'axios';
function redireccionarASubPaginaUsuario() {
  window.location.href = '/user';
}
export default {
  data() {
    return {
      propiedadRol: '',
      propiedadTipo: '',
      propiedadTamano: '',
      propiedadUbicacion: '',
      propiedadPrecio: '',
      propiedadImagen: '',
      propiedadDescripcion: '',
      valoracion: 0,
      contrato: '',
      propietario: '',
      estadoPropiedad: 1          
    }
  },
  methods: {
    async subirNewPropiedad() {
      const email_a= localStorage.getItem("login").slice(1, -1);
      const user_a= {
        "correo": email_a
      }

      //Conexion con Backend
      const rut_a = await axios.post(import.meta.env.VITE_BASE_URL + "usuario/obtener-rut", user_a);

      const new_propiedad = {
        "rol": this.propiedadRol,
        "tipo": this.propiedadTipo,
        "tamano": this.propiedadTamano,
        "ubicacion": this.propiedadUbicacion,
        "precio": this.propiedadPrecio,
        "imagenes": this.propiedadImagen,
        "descripcion": this.propiedadDescripcion,
        "valoracion": this.valoracion,
        "contrato": this.contrato,
        "propietario": {
          "rut": rut_a.data
        },
        "estadoPropiedad": {
          "idEstado": this.estadoPropiedad
        }
      };
      console.log("Enviando datos:", new_propiedad);
      try {
        const response = await axios.post(import.meta.env.VITE_BASE_URL + "propiedad/nueva", new_propiedad);
        if(response.data == 1){
          console.log("Respuesta del servidor:", response);
          alert("Propiedad subida con éxito");
          redireccionarASubPaginaUsuario();
        }
        else{
          console.log("Respuesta del servidor:", response);
          alert("Propiedad no subida");
        }

      } catch (error) {
        console.error("Error al subir la propiedad:", error);
        alert("Error al subir la propiedad");
      }
    },
    goBack() {
      this.$router.push('/user');}
  }
}
</script>
<style scoped>

.full-pantalla {
  display: flex;
  flex-direction: column;
  height: 100vh; 
  margin: 0;
  padding: 0;
  background-color: #f5f5f5;
}



.property-detail {
  position: relative; /* Necesario para posicionar el botón */
  padding: 20px;
  text-align: center; /* Centra el título horizontalmente */
  background-color: rgb(81, 81, 81);
}

.title-container {
  display: inline-block;
  
}

.property-detail h1 {
  color: rgb(255, 255, 255);
  margin: 0;
}

.back-button {
  position: absolute;
  top: 20px; 
  left: 20px; 
  background-color: #ddd;
  color: black;
}

.back-button:hover{
  background-color: red;
}


.fondo{
  background-color: #979897;
}


.subir-propiedad {
  margin: 20px 20px 20px 20px;
  background-color: #ffffff;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  max-width: 800px;
  margin-left: auto;
  margin-right: auto;
  overflow: hidden;
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.form-group {
  margin-bottom: 12px;
}

label {
  display: block;
  font-size: 14px;
  color: #333;
  margin-bottom: 5px;
}

input[type="text"],
input[type="number"] {
  width: 100%;
  padding: 8px;
  font-size: 14px;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-sizing: border-box;
}

button {
  background-color: #28a745;
  color: #ffffff;
  border: none;
  padding: 8px 16px;
  font-size: 16px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #218838;
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


</style>