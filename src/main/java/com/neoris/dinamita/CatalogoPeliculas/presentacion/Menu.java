package com.neoris.dinamita.CatalogoPeliculas.presentacion;

import com.neoris.dinamita.CatalogoPeliculas.modelo.Pelicula;
import com.neoris.dinamita.CatalogoPeliculas.modelo.Proveedor;
import com.neoris.dinamita.CatalogoPeliculas.servicio.IPeliculaServicio;

import java.util.Scanner;

public class Menu {

    public static void mostarMenu(){
        System.out.print("""
                **** Catalogo de Peliculas ****
                1. Agregar Pelicula
                2. Listar Peliculas
                3. Buscar Pelicula por Proveedor
                4. Eliminar Pelicula
                5. Salir
                Elige una opcion: 
                """);

    }

    public static boolean ejecutarOpciones(Scanner entrada, IPeliculaServicio peliculaServicio){

        int opcion = Integer.parseInt(entrada.nextLine());
        boolean salir = false;

        switch (opcion) {
            case 1 -> {
                System.out.println("--------Agregar Pelicula---------");
                Pelicula pelicula = new Pelicula();
                System.out.print("Ingresa el titulo de la pelicula: ");
                String titulo = entrada.nextLine();
                System.out.print("Ingresa el director de la pelicula: ");
                String director = entrada.nextLine();
                System.out.print("Ingresa la duración de la pelicula (hh:mm): ");
                String duracion = entrada.nextLine();
                System.out.print("Ingresa el género de la pelicula: ");
                String genero = entrada.nextLine();
                System.out.print("Ingresa el año de lanzamiento de la pelicula: ");
                int lanzamiento = entrada.nextInt();
                entrada.nextLine();
                System.out.print("Ingresa el proveedor de la pelicula: ");
                String nombreProveedor = entrada.nextLine();
                System.out.print("Ingresa el pais de origen del proveedor: ");
                String paisProveedor = entrada.nextLine();

                pelicula.setTitulo(titulo);
                pelicula.setDirector(director);
                pelicula.setDuracion(duracion);
                pelicula.setGenero(genero);
                pelicula.setLanzamiento(lanzamiento);
                pelicula.setProveedor(new Proveedor(nombreProveedor, paisProveedor));

                peliculaServicio.guardarPelicula(pelicula); //Agrega Pelicula

            }
            case 2 -> {
                System.out.println("--------Listado de Peliculas---------");
                peliculaServicio.listarPeliculas(); //Listar Peliculas
            }
            case 3 -> {
                System.out.println("--------Buscar Pelicula Por Proveedor---------");
                System.out.print("Ingresa el nombre del Proveedor: ");
                String proveedor = entrada.nextLine();

                peliculaServicio.buscarPeliculaPorProveedor(proveedor); //Pelicula por Proveedor
            }
            case 4 -> {
                System.out.println("--------Eliminar Pelicula---------");
                System.out.print("Ingresa el id de la Pelicula a eliminar: ");
                int idPelicula = entrada.nextInt();
                entrada.nextLine();

                peliculaServicio.eliminarPelicula(idPelicula); //Eliminar pelicua por Id
            }
            case 5 -> {
                System.out.println("--------Saliendo---------");
                System.out.println("Hasta la proxima");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: " + opcion);
        }
        System.out.println();
        return salir;

    }

}
