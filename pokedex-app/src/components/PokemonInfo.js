import useFetch from "../hooks/useFetch";
import { useContext, useState } from "react";
import { PokemonContext } from "../context/PokemonContext";
import Button from "./common/Button";
import Input from "./common/Input";
import PokemonDetails from "./common/PokemonDetails";

const PokemonInfo = ({ pokemonName }) => {
    const { data, loading, error } = useFetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`);
    const { dispatch } = useContext(PokemonContext);
    const [nickname, setNickname] = useState("");

    if (loading) return <p>Cargando...</p>;
    if (error || !data) return <p>Pokémon no encontrado</p>;

    const handleCapture = () => {
        const finalName = nickname.trim() !== "" ? nickname : data.name;

        dispatch({
            type: "CAPTURE",
            payload: {
                id: data.id,
                name: data.name,
                nickname: finalName,
                image: data.sprites.front_default,
                height: data.height,
                weight: data.weight,
                types: data.types.map(t => t.type.name),
                abilities: data.abilities.map(a => a.ability.name),
                stats: data.stats.map(s => ({ name: s.stat.name, value: s.base_stat })),
                date: new Date().toLocaleString(),
                inPC: false,
            }
        });

        setNickname(""); // Resetea el input después de capturar
    };

    return (
        <div className="pokemon-info-container">
            <PokemonDetails 
                pokemon={{
                    name: data.name,
                    image: data.sprites.front_default,
                    height: data.height,
                    weight: data.weight,
                    types: data.types.map(t => t.type.name),
                    abilities: data.abilities.map(a => a.ability.name),
                }}
            />

            <div className="capture-container">
                <Input 
                    placeholder="Ponle un apodo (opcional)" 
                    value={nickname} 
                    onChange={(e) => setNickname(e.target.value)}
                    className="capture-input"
                />
                <Button onClick={handleCapture} className="capture-button">Capturar</Button>
            </div>
        </div>
    );
};

export default PokemonInfo;
