package com.neoris.dinamita.CatalogoPeliculas.servicio;

import com.neoris.dinamita.CatalogoPeliculas.modelo.Pelicula;
import com.neoris.dinamita.CatalogoPeliculas.modelo.Proveedor;

import java.util.List;

public class PeliculaServicioArreglos implements IPeliculaServicio{

    @Override
    public List<Pelicula> listarPeliculas() {
        return List.of();
    }

    @Override
    public Pelicula buscarPeliculaPorProveedor(Proveedor proveedor) {
        return null;
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {

    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {

    }
}
