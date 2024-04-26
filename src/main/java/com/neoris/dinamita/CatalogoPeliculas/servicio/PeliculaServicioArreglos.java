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
    public List<Pelicula> listarPeliculas() {
        System.out.println("Lista peliculas");

        for(Pelicula pelicula: misPeliculas){
            System.out.println(pelicula);
        }
        return List.of();
    }

    @Override
    public Pelicula buscarPeliculaPorProveedor(Proveedor proveedor) {

        for(Pelicula pelicula: misPeliculas){
            if(pelicula.getProveedor().equals(proveedor)){
                System.out.println(pelicula.getTitulo() + " " + pelicula.getGenero() + " " + pelicula.getProveedor());
            }
        }
        return null;
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        misPeliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {
        misPeliculas.remove(pelicula);
        System.out.println("Se elimino la pelicula: " + pelicula);
    }
}
