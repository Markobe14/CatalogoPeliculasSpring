package com.neoris.dinamita.CatalogoPeliculas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;
import lombok.ToString;

@Data //Genera los métodos Getters y Setters
//@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Pelicula {
    private String id;
    private String titulo;
    private String director;
    private String duracion;
    private String genero;
    private int lanzamiento;

    private Proveedor proveedor;

    public Pelicula() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Pelicula(String titulo) {
        this();
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return id +
                "," + titulo +
                "," + director +
                "," + duracion  +
                "," + genero  +
                "," + lanzamiento +
                "," + proveedor;
    }
}
