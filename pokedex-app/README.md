# 🏆 Pokédex en React

Este proyecto es una **Pokédex interactiva** desarrollada en **React**. Utiliza **PokéAPI** para obtener información de los Pokémon y permite **capturarlos, asignarles un apodo, organizarlos en un equipo o en la PC, intercambiarlos y liberarlos**. 

El estado global de la aplicación se maneja con `useContext` y `useReducer`, y los datos de los Pokémon capturados **se almacenan en `localStorage`**, asegurando que no se pierdan al recargar la página.

---

## 📌 **Funcionalidades Principales**

✅ **Buscar Pokémon** en la API de [PokéAPI](https://pokeapi.co/api/v2/pokemon/)  
✅ **Capturar Pokémon** y asignarles un **apodo opcional**  
✅ **Límite de 6 Pokémon en el equipo**, los demás van a la **PC automáticamente**  
✅ **Intercambiar Pokémon entre el equipo y la PC** si el equipo está lleno  
✅ **Liberar Pokémon** de forma individual  
✅ **Persistencia de datos con `localStorage`**  
✅ **Diseño estilo Pokédex con interfaz organizada y responsive**  

---

## 🚀 **Instalación y Configuración**

### 1️⃣ **Clonar el Repositorio**
```bash
git clone https://github.com/tu-usuario/pokedex-react.git
cd pokedex-react
📂 src
 ├── 📂 components
 │    ├── 📂 common        # Componentes reutilizables
 │    │    ├── Button.js   # Botón reutilizable
 │    │    ├── Input.js    # Campo de entrada reutilizable
 │    │    ├── PokemonCard.js  # Tarjeta de Pokémon
 │    │    ├── PokemonList.js  # Lista de Pokémon (Equipo y PC)
 │    │    ├── PokemonDetails.js  # Detalles del Pokémon
 │    ├── CapturedList.js   # Lista de Pokémon capturados y gestión del equipo/PC
 │    ├── PokemonInfo.js    # Información del Pokémon buscado y captura
 │    ├── SearchPokemon.js  # Buscador de Pokémon
 ├── 📂 context
 │    ├── PokemonContext.js  # Gestión global de Pokémon capturados
 ├── 📂 hooks
 │    ├── useFetch.js  # Hook para obtener datos de la API
 ├── App.js
 ├── App.css
 ├── index.js
 ├── package.json
 ├── README.md

---

## **📌 Explicación Adicional**
✅ **Explica todas las funcionalidades en detalle**  
✅ **Describe la estructura del código con claridad**  
✅ **Incluye capturas de pantalla para una mejor presentación**  
✅ **Ofrece información sobre futuras mejoras y contribuciones**  
✅ **Código limpio y bien documentado**  

💡 **¡Listo para que tu profesor entienda todo en detalle!** 🚀  
Si quieres que agregue algo más, dime. 😊
