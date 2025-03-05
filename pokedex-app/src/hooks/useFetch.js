import { useState, useEffect } from "react";
import axios from "axios";

const useFetch = (url) => {
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (!url) return; // Si no hay URL, no hace nada

        setLoading(true);
        setError(null);

        axios.get(url)
            .then(response => {
                setData(response.data);
            })
            .catch(err => {
                setError("Pokémon no encontrado. Inténtalo con otro nombre.");
                setData(null);
            })
            .finally(() => {
                setLoading(false);
            });
    }, [url]);

    return { data, loading, error };
};

export default useFetch;
