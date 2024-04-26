package com.neoris.dinamita.CatalogoPeliculas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //Genera los métodos Getters y Setters
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pelicula {

    private int id;
    private String titulo;
    private String director;
    private String duracion;
    private String genero;
    private int añoLanzamiento;

    private Proveedor proveedor;


}
