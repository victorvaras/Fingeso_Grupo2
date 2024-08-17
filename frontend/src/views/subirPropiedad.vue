<template>
    <div class="full-pantalla">

        <header>
            <h1>Subir Propiedad</h1>
        </header>

        <section class="subir-propiedad">
            <h2>Formulario para Subir Propiedad</h2>
            <form id="propertyForm" @submit.prevent="subirNewPropiedad">
                <div class="form-group">
                   <!-- <label for="propiedad-Rol">ROL de propiedad:</label> --> 
                    <input type="text" placeholder="ROL de propiedad" v-model="propiedadRol" required>
                </div>
                <div class="form-group">
                    <!-- <label for="propiedad-tipo">Tipo de propiedad:</label> -->
                    <input type="text" placeholder="Tipo de propiedad" v-model="propiedadTipo" required>
                </div>
                <div class="form-group">
                    <!-- <label for="propiedad-tamaño">Tamaño propiedad:</label> -->
                    <input type="number" placeholder="Tamaño propiedad" v-model="propiedadTamano" required>
                </div>
                <div class="form-group">
                    <!-- <label for="propiedad-ubicacion">Ubicación:</label>  -->
                    <input type="text" placeholder="Ubicación" v-model="propiedadUbicacion" required>
                </div>
                <div class="form-group">
                    <!-- <label for="propiedad-precio">Precio propiedad:</label>  -->
                    <input type="number" placeholder="Precio propiedad" v-model="propiedadPrecio" required>
                </div>
                <div class="form-group">
                    <!-- <label for="propiedad-imagen">Imagen propiedad:</label>  -->
                    <input type="text" placeholder="Imagen propiedad" v-model="propiedadImagen" required>
                </div>
                <div class="form-group">
                    <!--<label for="propiedad-descripcion">Descripción propiedad:</label>  -->
                    <input type="text" placeholder="Descripción propiedad" v-model="propiedadDescripcion" required>
                </div>

                <button type="submit">Subir Propiedad</button>
            </form>
        </section>
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
            //propietario: '12345678-9',  // Ejemplo de valor predeterminado
            propietario: '',
            estadoPropiedad: 1          // Ejemplo de valor predeterminado
        }
    },

    methods: {
        async subirNewPropiedad() {

            const email_a= localStorage.getItem("login").slice(1, -1);

            const user_a= {
                "correo": email_a
            }

            
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

            console.log("Enviando datos:", new_propiedad); // Para depuración

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
                console.error("Error al subir la propiedad:", error); // Mejorado para depuración
                alert("Error al subir la propiedad");
            }
        }
    }
}
</script>




<style scoped>
/* Aplica el estilo a toda la vista */
.full-pantalla {
    display: flex;
    flex-direction: column;
    height: 100vh; /* Ocupa toda la altura de la ventana */
    margin: 0;
    padding: 0;
    background-color: #f5f5f5; /* Color de fondo suave */
}

/* Estilo para el encabezado */
header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 50px; /* Altura del encabezado reducida */
    background-color: #ffffff; /* Fondo blanco para el encabezado */
    text-align: center;
    line-height: 50px; /* Centra verticalmente el texto */
    font-size: 20px;
    font-style: italic; /* Texto en cursiva */
    box-shadow: 0 2px 4px rgba(0,0,0,0.1); /* Sombra ligera para el encabezado */
    z-index: 1000; /* Asegura que el encabezado esté en la parte superior */
}

/* Estilo para la sección del formulario */
.subir-propiedad {
    margin: 80px 20px 20px 20px; /* Ajusta el margen inferior para dejar espacio para el encabezado */
    background-color: #ffffff; /* Fondo blanco para el formulario */
    padding: 15px;
    border-radius: 8px; /* Bordes redondeados */
    box-shadow: 0 2px 4px rgba(0,0,0,0.1); /* Sombra ligera para el formulario */
    max-width: 800px; /* Ancho máximo del formulario */
    margin-left: auto;
    margin-right: auto;
    overflow: hidden; /* Evita que el contenido se desborde */
    flex: 1; /* Permite que el formulario crezca y ocupe el espacio disponible */
    display: flex;
    flex-direction: column;
    justify-content: center; /* Centra verticalmente el formulario */
}





/* Estilo para los grupos de formularios */
.form-group {
    margin-bottom: 12px; /* Espacio entre los campos del formulario reducido */
}

/* Estilo para las etiquetas del formulario */
label {
    display: block;
    font-size: 14px;
    color: #333; /* Color de texto oscuro para contraste */
    margin-bottom: 5px;
}

/* Estilo para los campos de entrada del formulario */
input[type="text"],
input[type="number"] {
    width: 100%;
    padding: 8px; /* Reducido el padding para campos más pequeños */
    font-size: 14px;
    border: 1px solid #ddd; /* Borde sutil */
    border-radius: 4px; /* Bordes redondeados en los campos de entrada */
    box-sizing: border-box;
}

/* Estilo para el botón de enviar */
button {
    background-color: #28a745; /* Color verde para el botón */
    color: #ffffff; /* Texto blanco */
    border: none;
    padding: 8px 16px; /* Reducido el padding del botón */
    font-size: 16px;
    border-radius: 4px; /* Bordes redondeados en el botón */
    cursor: pointer; /* Cambia el cursor cuando se pasa sobre el botón */
    transition: background-color 0.3s ease; /* Transición suave del color de fondo */
}

/* Estilo para el botón al pasar el ratón sobre él */
button:hover {
    background-color: #218838; /* Color verde más oscuro al pasar el ratón */
}


</style>