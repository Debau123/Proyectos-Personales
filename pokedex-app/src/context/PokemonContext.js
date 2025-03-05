import { createContext, useReducer, useEffect } from "react";

export const PokemonContext = createContext();

const pokemonReducer = (state, action) => {
    switch (action.type) {
        case "CAPTURE":
            const teamCount = state.filter(p => !p.inPC).length;
            const newPokemon = { ...action.payload, uniqueId: Date.now(), inPC: teamCount >= 6 };

            if (teamCount >= 6) {
                alert(`${newPokemon.nickname.toUpperCase()} ha sido enviado a la PC porque tu equipo está lleno.`);
            }

            return [...state, newPokemon];

        case "RELEASE":
            return state.filter(pokemon => pokemon.uniqueId !== action.payload);

        case "MOVE_TO_PC":
            return state.map(pokemon =>
                pokemon.uniqueId === action.payload ? { ...pokemon, inPC: true } : pokemon
            );

        case "MOVE_TO_TEAM":
            const team = state.filter(p => !p.inPC);
            if (team.length >= 6) {
                return state; // No permite más de 6 en el equipo sin intercambio
            }
            return state.map(pokemon =>
                pokemon.uniqueId === action.payload ? { ...pokemon, inPC: false } : pokemon
            );

        case "SWAP_TEAM_PC":
            return state.map(pokemon => {
                if (pokemon.uniqueId === action.payload.teamPokemon) {
                    return { ...pokemon, inPC: true };
                } else if (pokemon.uniqueId === action.payload.pcPokemon) {
                    return { ...pokemon, inPC: false };
                }
                return pokemon;
            });

        default:
            return state;
    }
};

export const PokemonProvider = ({ children }) => {
    const [capturedPokemons, dispatch] = useReducer(
        pokemonReducer,
        JSON.parse(localStorage.getItem("capturedPokemons")) || []
    );

    useEffect(() => {
        localStorage.setItem("capturedPokemons", JSON.stringify(capturedPokemons));
    }, [capturedPokemons]);

    return (
        <PokemonContext.Provider value={{ capturedPokemons, dispatch }}>
            {children}
        </PokemonContext.Provider>
    );
};
