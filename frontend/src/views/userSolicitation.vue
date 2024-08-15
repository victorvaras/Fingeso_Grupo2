<template>
    <!-- Todas las class que se declaran es para poder trabajar mas comodamente con los css
     -->
    <div class="portal-usuario">
        <header>
            <h1>Portal Usuario</h1>
            <nav>
                <ul>
                    <li><a href="#home">Inicio</a></li>
                    <li><a href="#properties">Propiedades</a></li>
                    <li><a href="#contact">Contacto</a></li>
                    <!-- Por mientras para saber que usuario esta conectado-->
                    <span class="username">{{ username }}</span>
                </ul>
            </nav>
        </header>

        <section class="hero">
            <h1>Propiedades Ideales</h1>
            <!-- Parrafo-->
            <p>Explora las propiedades ideales que hay para ti</p>
        </section>

        <!-- Dado el id cuando se presione properties te manda a esta seccion -->
        <section id="properties" class="properties">
            <h1>Propiedades Disponibles</h1>

            <!-- Se crean containers para las cartas -->
            <div class="card-container"> 
                <div class="card">
                    <img src="./media/img1.jpg" alt="Imagen propiedad">
                    <div class="card-content">
                        <h3>Propiedad 1</h3>
                        <p>Descripcion propiedad 1</p>
                        <p>Precio: $2000/mes</p>
                        <button>Ver más detalles</button>
                    </div>
                </div>
                <div class="card">
                    <img src="./media/img2.jpg" alt="Imagen propiedad">
                    <div class="card-content">
                        <h3>Propiedad 2</h3>
                        <p>Descripcion propiedad 2 aaaaaaaaaa aaaaa asdjhasdjh ajhdajhasdjhas asdjhasjhdas hola</p>
                        <p>Precio: $5000/mes</p>
                        <button>Ver más detalles</button>
                    </div>
                </div>
            </div>
            
        </section>

    </div>

</template>

<script>
    export default {
  data() {
    return {
      username: ""
    };
  },
  mounted() {
    // Recupera el nombre de usuario de localStorage
    const storedUsername = localStorage.getItem("login");
    if (storedUsername) {
      this.username = JSON.parse(storedUsername);
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

.portal-usuario {
    text-align: center;
}

header {
    background-color: rgb(77, 244, 188);
    color: aliceblue;
    padding: 10px 0;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

nav ul li {
    display: inline;
    margin: 0 15px;
}

nav ul li a {
    background-color: rgb(93, 219, 247);
    border: none;
    border-radius: 10px;
    color: aliceblue;
    cursor: pointer;
    padding: 10px 20px;
    text-decoration: none;
    transition: background-color 0.2s;
    /*transition: 0.3s;*/
}

.hero {
    color: rgb(255, 255, 255);
    background-color: rgb(185, 206, 224);
    padding: 50px 0;
}

.hero h1 {
    font-size: 2.5em;
}

.properties {
    color: rgb(255, 255, 255);
    padding: 50px 0;
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
    background-color: blue;
    border: none;
    border-radius: 4px;
    color: white;
    cursor: pointer;
    padding: 10px;
    width: 100%;
}

.card-content button:hover {
    background-color: aqua;
}

</style>