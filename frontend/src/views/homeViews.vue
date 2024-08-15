<script setup>

</script>


<template>
    <!-- Esta sección define la estructura visual y la interfaz de usuario del componente. Aquí se construye el formulario 
     que permite a los usuarios iniciar sesión o registrarse -->
    <main>
        <div class = "general">
            <div class = "content">
                <img class = "image" src = "./media/hogar.png">
                    <div class = "header">Hogar a un Click</div>

                    <!-- Descripción del encabezado que cambia según el estado 'register' (variable) -->
                    <div class = "headerDescription" v-if="!register">
                        Completar campos Iniciar sesion
                    </div>
                    <div class = "headerDescription" v-else>
                        Completar campos Registro
                    </div>

                    <!-- Formulario de inicio de sesión -->
                    <div class = "inputContainer" v-if="!register"> 
                        <!-- Campos de entrada (inputs) 
                             Los campos de entrada en ambos formularios están vinculados a variables en el componente Vue utilizando v-model. 
                             Esto asegura que los datos ingresados por el usuario se almacenen automáticamente en las variables correspondientes

                             v-model="email": Vincula el campo de entrada de correo electrónico con la variable email del componente
                             Cualquier cambio en este campo se reflejará automáticamente en la variable email
                         -->
                        <input type="email" v-model="email"  placeholder="Ingrese Correo">
                        <input type="password" v-model="password"  placeholder="Ingrese Contraseña">
                        
                        <!-- @click="login": Cuando se hace clic en este botón, se llama al método login, que se encarga 
                             de enviar los datos del usuario al backend para intentar iniciar sesión
                        -->
                        <button class = "sessionButton" @click="login">Iniciar Sesion</button>
                    </div>   

                    <!-- Formulario de registro (register = true)-->
                    <div class = "inputContainer" v-else>
                        
                        <!-- <label for="rut">Ingrese su RUT:</label> -->
                        <input type="text" id="rut" v-model="rut" placeholder="Ingrese RUT: 12.345.678-9">
                        <input type="text" v-model="usernameLastNameRegister"  placeholder="Ingrese Nombre Apellidos">
                        <input type="email" v-model="usernameRegister"  placeholder="Ingrese Correo">
                        
                        <!-- input: etiqueta HTML => representa un campo de entrada a recibir por el usuario
                             type="password" => indica que el campo de entrada es tipo contraseña (lo que el usuario escriba se muestra como *)
                             v-model: directiva de Vue.js crea un enlace bidireccional entre el valor del campo de entrada y una propiedad definida en la instancia del componente Vue
                             v-model="passwordRegister" conecta el valor del campo de entrada con la propiedad passwordRegister en el objeto data del componente Vue
                             placeholder: atributpo HTML => muestra texto gris dentro del campo de entrada cuando esta vacio
                        -->
                        <input type="password" v-model="passwordRegister"  placeholder="Ingrese Contraseña">
                        <!-- v-model="passwordRegisterConfirmation": Vincula el campo de entrada para confirmar la contraseña con la variable passwordRegisterConfirmation
                        -->
                        <input type="password" v-model="passwordRegisterConfirmation"  placeholder="Repita Contraseña">
                        
                        <!-- @click="addUser": Cuando se hace clic en este botón, se llama al método addUser, que se encarga de validar las contraseñas y enviar los 
                             datos al backend para registrar un nuevo usuario
                        -->
                        <button class = "sessionButton" @click="addUser">Registrar</button>
                    </div>

                    <!-- Botones adicionales para cambiar entre inicio de sesión, registro y modo anónimo -->
                    <div class = "alsoButtons">
                        <div class="alsoButton" @click ="handleChange" v-if="!register">
                            Registrarse
                        </div>
                        <div class="alsoButton" @click ="handleChange" v-else>
                            Iniciar Sesion
                        </div>
                        <!-- anonimo 
                        <router-link to="user">
                            <div class="alsoButton" @click ="handleChange">Anonimo</div>
                        </router-link>
                        -->
                        <div class="alsoButton" @click ="anonimo">Anonimo</div>

                    </div>
                </img>
            </div>
        </div>
    </main>

</template>

<script>
    /*
    Esta sección maneja la lógica del componente, incluyendo los datos 
    reactivos y los métodos que manipulan dichos datos o realizan acciones específicas
    */

    // Se importa axios para manejar las solicitudes HTTP (anteriormente se uso postman)
    import axios from 'axios'

    // Función para redireccionar a la página de usuario autenticado
    function redireccionarASubPaginaUsuario() {
        window.location.href = '/user';
    }

    // Función para redireccionar a la página de usuario anónimo
    function redireccionarASubPaginaUsuarioAnonimo() {
        window.location.href = '/user';
    }

    /* El componente Vue se define como un objeto JavaScript que se exporta utilizando export default. Este objeto 
    contiene varias propiedades, como data, methods, computed, y watch, entre otras, que definen el comportamiento del componente
    */
    export default {

        /*
        Define los datos reactivos del componente, incluyendo campos para el formulario de 
        inicio de sesión y registro, así como estados para controlar la interfaz.
        
        register: Es una propiedad reactiva que se inicializa con el valor false. Esto significa que, 
        cuando el componente se monta, por defecto, el formulario que se mostrará es el de inicio de sesión, no el de registro
        */
        data(){
            // Esta funcion retorna un objeto con las propiedades reactivas del componente
            // Por ahora no se consideran usuarios especiales
            return{
                email: '',                       // por ahora, asociado a email para inicio de sesion
                password: '',                       // contraseña para inicio de sesion

                loggedIn: false,                    // Estado de inicio de sesión
                register: false,                    // Estado para alternar entre registro y inicio de sesión (formularios)
                
                rut:'',                             // rut usuario para registro
                usernameLastNameRegister: '',       // nombre y apellidos para registro
                usernameRegister: '',               // por ahora, correo electrónico para registro
                passwordRegister: '',               // contraseña para registro
                passwordRegisterConfirmation: '',   // confirmacion de contraseña
            }
        },

        // Contiene los métodos que manejan las acciones del usuario
        /*
        Los métodos dentro del componente Vue definen la lógica que se ejecuta en respuesta a eventos 
        de la interfaz de usuario, como clics de botones
        */
        methods:{
            // Método para manejar el inicio de sesión
            async login() {
                //envio de datos al backend
                //Aqui los atributos definidos en usuario deben ser los mismos que en el backend
                const usuario = {
                    "email": this.email,
                    "password": this.password
                };
                try {
                    // Envia una solicitud POST al backend con usuario
                    //const respuesta = await axios.post(import.meta.env.VITE_BASE_URL + "api/usuario/login", usuario);
                    const respuesta = {
                        data: 3
                    };
                    // Manejo de diferentes respuestas del backend
                    // Distintos tipos de usuario redireccionan a distintas pantallas
                    if(respuesta.data == 1) {
                        return 0;
                    }
                    if(respuesta.data == 2){
                        return 0;
                    }
                    if(respuesta.data == 3){ // tipo deusuario? => redirecciona a la vista que le corresponde al usuario
                        /*
                        Almacenar el Nombre de Usuario: Este código guarda el valor de this.email en localStorage bajo la clave "login" 
                        Por ejemplo, si this.email es "usuario123", entonces la clave "login" en localStorage tendrá el valor "usuario123"
                        */
                        localStorage.setItem("login", JSON.stringify(this.email));
                        redireccionarASubPaginaUsuario();
                        //alert("Inicio correcto");
                    }
                    
                    if(respuesta.data == 0){
                        alert("Credenciales invalidas");
                    }
                    respuesta.data = 0;
                    console.log(respuesta.data);
                } catch (error) {
                    alert("No se genera conexión con el servidor");  
                }
            },

            // Método para alternar entre el formulario de inicio de sesión y registro
            handleChange(){
                // Alterna el estado de register para cambiar entre los formularios de inicio de sesión y registro
                this.register = !this.register
                console.log(this.register) 
            },

            // Método para manejar el modo anónimo
            anonimo(){
                this.email = "anonimo"
                redireccionarASubPaginaUsuarioAnonimo();
                localStorage.setItem("login", JSON.stringify(this.email));
                alert("Inicio anonimo correcto");
            },

            // Método para registrar un nuevo usuario
            async addUser() { // Cambiado aquí
                //Envio de datos al backend
                if (this.passwordRegister == this.passwordRegisterConfirmation){
                    if(this.usernameRegister != '' & this.passwordRegister != ''){
                        const nuevo_usuario = {
                            "email": this.usernameRegister,
                            "password": this.passwordRegister,
                            "rol": "usuario"
                        }
                        try {
                            const registro = await axios.post(import.meta.env.VITE_BASE_URL + "api/usuario/register", nuevo_usuario);
                            console.log(registro)
                            alert("Usuario creado con exito")
                        } catch (error) {
                            alert("No se pudo registrar al usuario")       
                        }
                    }
                    else{
                        alert("No hay datos ingresados")
                    }
                }
                else{
                    alert("Las contraseñas no coinciden")
                }
            }
        }
    }

</script>

<style scoped>

/*
html, body {
    height: 100%;
    margin: 0;
    padding: 0;
}
*/
.general {

    /*background-image: url("./media/img2.jpg");*/
    background-color: rgb(81, 81, 81);
    height: 100vh;
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;
    display: flex;
    justify-content: center;
    align-items: center;
    align-content: center;
    margin: 0;

}

.image {
    height: 100px;
}

.content {
    box-sizing: border-box;
    /*padding: 10px;*/
    padding: 20px; /* Asegura un buen espacio interno */
    background-color: rgb(213, 216, 220);
    display: flex;
    flex-direction: column;
    align-items: center;
    min-width: 300px;
    max-width: 500px;
    width: 100%;
    margin: 0px 10px 0px 10px;
    /*min-height: 600px;*/
    /*max-height: 700px;*/
    /*height: 100%;*/
    border-radius: 30px;
}

.header {
    text-align: center;
    line-height: 1;
    font-size: 40px;
    font-weight: 500 !important;
    color: black;
}

.headerDescription {
    font-size: 16px;
    margin-top: 10px;
    margin-bottom: 5px;
    color: black;
}

.inputContainer {
    display: flex;
    flex-direction: column;  /* Apila los inputs uno debajo del otro */
    align-items: center;     /* Centra los inputs horizontalmente */
    justify-content: center; /* Centra los inputs verticalmente dentro del contenedor */
    width: 100%;             /* Asegura que el contenedor ocupe todo el ancho disponible */
}


input {
    height: 50px;
    box-sizing: border-box;
    padding: 10px !important;
    font-size: 16px;
    border-radius: 4px;
    outline: none;
    border: #cdcdcd solid 3px;
    transition: border 0.2s;
    margin-bottom: 5px; 
}

input:hover {
    border: #bbbbbb solid 3px;
    transition: border 0.2s;
}

input:focus {
    border: #888888 solid 3px;
    transition: border 0.2s;
}

.alsoButtons {
    display: flex;
    width: 400px;
    width: 100%;
    max-width: 400px;
    justify-content: space-between;
    color: black;
}

.sessionButton {
    height: 50px;
    background-color: rgb(119, 199, 127);
    color: aliceblue;
    font-size: 16px;
    font-weight: 500;
    border: rgb(96, 217, 146) solid 2px;
    border-radius: 3px;
    cursor: pointer;
    transition: background-color 0.2s;
    margin-bottom: 10px;
}

.sessionButton:hover {
    background-color: lightblue;
    transition: background-color 0.2s;
}


.alsoButton {
    cursor: pointer;
    font-weight: 500;
    transition: all 0.2s;
    color: black; 
}

.alsoButton:hover {
    text-decoration: underline;
    transition: all 0.2s;
}

/*
@media (min-width: 418px){
    .content {
        max-height: 500px;
    }
}
*/
</style>

