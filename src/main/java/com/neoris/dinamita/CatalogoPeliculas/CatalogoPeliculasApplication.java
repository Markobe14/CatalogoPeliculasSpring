package com.neoris.dinamita.CatalogoPeliculas;

import com.neoris.dinamita.CatalogoPeliculas.modelo.Pelicula;
import com.neoris.dinamita.CatalogoPeliculas.modelo.Proveedor;
import com.neoris.dinamita.CatalogoPeliculas.presentacion.Menu;
import com.neoris.dinamita.CatalogoPeliculas.servicio.IPeliculaServicio;
import com.neoris.dinamita.CatalogoPeliculas.servicio.PeliculaServicioArchivo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CatalogoPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoPeliculasApplication.class, args);

		boolean salir = false;
		Scanner entrada = new Scanner(System.in);

		IPeliculaServicio peliculaServicio = new PeliculaServicioArchivo();

		while (!salir){
			try{
				Menu.mostarMenu();
				salir = Menu.ejecutarOpciones(entrada, peliculaServicio);
			} catch (Exception ex){
				System.out.println("Ocurrio un error: " + ex.getMessage());
			}
			System.out.println();
		}

	}

}
