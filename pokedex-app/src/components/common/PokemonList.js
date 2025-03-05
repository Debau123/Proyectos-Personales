import PokemonCard from "./PokemonCard";

const PokemonList = ({ pokemons, onMove, onRelease, title, showMoveButton = true }) => {
    return (
        <div>
            <h2>{title}</h2>
            <div className="pokemon-grid">
                {pokemons.length === 0 ? <p>No hay Pokémon</p> : pokemons.map(pokemon => (
                    <PokemonCard 
                        key={pokemon.uniqueId} 
                        pokemon={pokemon} 
                        onMove={onMove} 
                        onRelease={onRelease}
                        showMoveButton={showMoveButton}
                    />
                ))}
            </div>
        </div>
    );
};

export default PokemonList;
