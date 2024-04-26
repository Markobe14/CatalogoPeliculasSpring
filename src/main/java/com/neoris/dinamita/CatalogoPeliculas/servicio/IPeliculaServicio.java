package com.neoris.dinamita.CatalogoPeliculas.servicio;

import com.neoris.dinamita.CatalogoPeliculas.modelo.Pelicula;
import com.neoris.dinamita.CatalogoPeliculas.modelo.Proveedor;

import java.util.List;

public interface IPeliculaServicio {

    public void listarPeliculas();

    public void buscarPeliculaPorProveedor(Pelicula pelicula);

    public void guardarPelicula(Pelicula pelicula);

    //public void modificarPelicula(Pelicula pelicula);

    public void eliminarPelicula(int peliculaId);

}
