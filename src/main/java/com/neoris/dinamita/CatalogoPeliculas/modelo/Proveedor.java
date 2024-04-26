package com.neoris.dinamita.CatalogoPeliculas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //Genera los métodos Getters y Setters
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Proveedor {

    //private String id;
    private String nombre;
    private String pais;


    @Override
    public String toString() {
        return nombre  +
                "," + pais ;
    }
}
