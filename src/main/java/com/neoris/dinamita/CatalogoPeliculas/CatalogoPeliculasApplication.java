package com.neoris.dinamita.CatalogoPeliculas;

import com.neoris.dinamita.CatalogoPeliculas.modelo.Pelicula;
import com.neoris.dinamita.CatalogoPeliculas.modelo.Proveedor;
import com.neoris.dinamita.CatalogoPeliculas.servicio.PeliculaServicioArchivo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoPeliculasApplication.class, args);

		Pelicula pelicula1 = new Pelicula();
		pelicula1.setTitulo("spyderman");
		pelicula1.setDirector("Marco Aguirre");
		pelicula1.setDuracion("02:45");
		pelicula1.setGenero("Comedia");
		pelicula1.setLanzamiento(2024);
		pelicula1.setProveedor(new Proveedor("Sony","Japon"));

		Pelicula pelicula2 = new Pelicula();
		pelicula2.setTitulo("batman");
		pelicula2.setDirector("Marco Aguirre");
		pelicula2.setDuracion("02:45");
		pelicula2.setGenero("Terror");
		pelicula2.setLanzamiento(2024);
		pelicula2.setProveedor(new Proveedor("Marvel","USA"));

		Pelicula pelicula3 = new Pelicula();
		pelicula3.setTitulo("transformers");
		pelicula3.setDirector("jsoe corona");
		pelicula3.setDuracion("02:45");
		pelicula3.setGenero("suspenso");
		pelicula3.setLanzamiento(2024);
		pelicula3.setProveedor(new Proveedor("Universal","USA"));

		Pelicula pelicula4 = new Pelicula();
		pelicula4.setTitulo("peliculaaaaa");
		pelicula4.setDirector("corona");
		pelicula4.setDuracion("02:45");
		pelicula4.setGenero("suspenso");
		pelicula4.setLanzamiento(2024);
		pelicula4.setProveedor(new Proveedor("Disney","USA"));

		Pelicula pelicula5 = new Pelicula();
		pelicula5.setTitulo("Avengers");
		pelicula5.setDirector("corona");
		pelicula5.setDuracion("02:45");
		pelicula5.setGenero("accion");
		pelicula5.setLanzamiento(2024);
		pelicula5.setProveedor(new Proveedor("Marvel","USA"));

		//System.out.println(pelicula2);
		PeliculaServicioArchivo archivo = new PeliculaServicioArchivo();
		//archivo.guardarPelicula(pelicula1);
		//archivo.guardarPelicula(pelicula2);
		//archivo.guardarPelicula(pelicula3);
		//archivo.guardarPelicula(pelicula4);
		//archivo.guardarPelicula(pelicula5);
		archivo.buscarPeliculaPorProveedor("Marvel");
		//archivo.eliminarPelicula(4);
		//archivo.listarPeliculas();

	}

}
