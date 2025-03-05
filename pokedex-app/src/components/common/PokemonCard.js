import Button from "./Button";

const PokemonCard = ({ pokemon, onMove, onRelease, showMoveButton = true }) => {
    return (
        <div className="pokemon-card">
            <h3>{pokemon.nickname}</h3>
            <img src={pokemon.image} alt={pokemon.name} />
            <p><strong>Capturado el:</strong> {pokemon.date}</p>
            
            {showMoveButton && <Button onClick={() => onMove(pokemon.uniqueId)}>Mover</Button>}
            <Button onClick={() => onRelease(pokemon.uniqueId)}>Liberar</Button>
        </div>
    );
};

export default PokemonCard;
