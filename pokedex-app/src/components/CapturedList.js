import { useContext, useState } from "react";
import { PokemonContext } from "../context/PokemonContext";
import Button from "./common/Button";
import PokemonList from "./common/PokemonList";

const CapturedList = () => {
    const { capturedPokemons, dispatch } = useContext(PokemonContext);
    const [showPC, setShowPC] = useState(false);
    const [selectedPCPokemon, setSelectedPCPokemon] = useState(null);
    const [selectedTeamPokemon, setSelectedTeamPokemon] = useState(null);

    const handleRelease = (uniqueId) => {
        dispatch({ type: "RELEASE", payload: uniqueId });
    };

    const handleMoveToPC = (uniqueId) => {
        dispatch({ type: "MOVE_TO_PC", payload: uniqueId });
    };

    const handleMoveToTeam = (uniqueId) => {
        const teamCount = capturedPokemons.filter(p => !p.inPC).length;
        if (teamCount >= 6) {
            setSelectedPCPokemon(uniqueId);
            return;
        }
        dispatch({ type: "MOVE_TO_TEAM", payload: uniqueId });
    };

    const handleSwapPokemon = () => {
        if (selectedPCPokemon && selectedTeamPokemon) {
            dispatch({ type: "SWAP_TEAM_PC", payload: { pcPokemon: selectedPCPokemon, teamPokemon: selectedTeamPokemon } });
            setSelectedPCPokemon(null);
            setSelectedTeamPokemon(null);
        }
    };

    return (
        <div>
            <PokemonList 
                title="Mi Equipo" 
                pokemons={capturedPokemons.filter(p => !p.inPC).slice(0, 6)}
                onMove={handleMoveToPC}
                onRelease={handleRelease}
            />

            <Button onClick={() => setShowPC(!showPC)}>
                {showPC ? "Ocultar PC" : "Mostrar PC"}
            </Button>

            {showPC && (
                <PokemonList 
                    title="PC" 
                    pokemons={capturedPokemons.filter(p => p.inPC)}
                    onMove={handleMoveToTeam}
                    onRelease={handleRelease}
                />
            )}

            {selectedPCPokemon && (
                <div className="swap-container">
                    <h3>Elige un Pokémon del equipo para intercambiar</h3>
                    <div className="pokemon-grid">
                        {capturedPokemons.filter(p => !p.inPC).slice(0, 6).map(pokemon => (
                            <div key={pokemon.uniqueId} className="pokemon-card">
                                <h3>{pokemon.name}</h3>
                                <img src={pokemon.image} alt={pokemon.name} />
                                <Button onClick={() => setSelectedTeamPokemon(pokemon.uniqueId)}>Seleccionar</Button>
                            </div>
                        ))}
                    </div>
                    <Button onClick={handleSwapPokemon} disabled={!selectedTeamPokemon}>
                        Confirmar Intercambio
                    </Button>
                </div>
            )}
        </div>
    );
};

export default CapturedList;
