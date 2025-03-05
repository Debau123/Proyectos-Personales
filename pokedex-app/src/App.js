import { useState } from "react";
import { PokemonProvider } from "./context/PokemonContext";
import SearchPokemon from "./components/SearchPokemon";
import PokemonInfo from "./components/PokemonInfo";
import CapturedList from "./components/CapturedList";
import "./App.css";


function App() {
    const [pokemonName, setPokemonName] = useState("");

    return (
        <PokemonProvider>
            <div>
                <h1>Pokédex</h1>
                <SearchPokemon setPokemon={setPokemonName} />
                {pokemonName && <PokemonInfo pokemonName={pokemonName} />}
                <CapturedList />
            </div>
        </PokemonProvider>
    );
}

export default App;
