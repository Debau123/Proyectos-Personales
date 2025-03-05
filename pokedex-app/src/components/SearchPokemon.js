import { useState } from "react";
import Button from "./common/Button";
import Input from "./common/Input";

const SearchPokemon = ({ setPokemon }) => {
    const [search, setSearch] = useState("");

    const handleSearch = () => {
        if (!search.trim()) return;
        setPokemon(search.toLowerCase());
    };

    return (
        <div className="pokedex-container">
            <h2>Pokédex</h2>
            <Input
                placeholder="Introduce el nombre del Pokémon"
                value={search}
                onChange={(e) => setSearch(e.target.value)}
            />
            <Button onClick={handleSearch}>Buscar</Button>
        </div>
    );
};

export default SearchPokemon;
