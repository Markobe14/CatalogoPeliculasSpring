package com.neoris.dinamita.CatalogoPeliculas.servicio;

import com.neoris.dinamita.CatalogoPeliculas.modelo.Pelicula;
import com.neoris.dinamita.CatalogoPeliculas.modelo.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class PeliculaServicioArreglos implements IPeliculaServicio{

    private final List<Pelicula> misPeliculas;

    public PeliculaServicioArreglos(){
        misPeliculas =new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Lista peliculas");

        for(Pelicula pelicula: misPeliculas){
            System.out.println(pelicula);
        }
    }

    @Override
    public void buscarPeliculaPorProveedor(String proveedor) {

        for(Pelicula miPelicula: misPeliculas){
            if(miPelicula.getProveedor().equals(proveedor)){
                System.out.println(miPelicula.getId() + miPelicula.getTitulo() + " " + miPelicula.getGenero() + " " + miPelicula.getProveedor());
            }
        }
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        misPeliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void eliminarPelicula(String peliculaId) {
        misPeliculas.remove(peliculaId);
        System.out.println("Se elimino la pelicula: " + peliculaId);
    }
}
