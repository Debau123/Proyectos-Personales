const PokemonDetails = ({ pokemon }) => {
    return (
        <div className="pokemon-info">
            <h2>{pokemon.name.toUpperCase()}</h2>
            <img src={pokemon.image} alt={pokemon.name} />
            <p><strong>Altura:</strong> {pokemon.height}</p>
            <p><strong>Peso:</strong> {pokemon.weight}</p>
            <p><strong>Tipos:</strong> {pokemon.types.join(", ")}</p>
            <p><strong>Habilidades:</strong> {pokemon.abilities.join(", ")}</p>
        </div>
    );
};

export default PokemonDetails;
