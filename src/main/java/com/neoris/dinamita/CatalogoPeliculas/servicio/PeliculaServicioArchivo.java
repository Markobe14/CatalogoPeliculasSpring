package com.neoris.dinamita.CatalogoPeliculas.servicio;

import com.neoris.dinamita.CatalogoPeliculas.modelo.Pelicula;
import com.neoris.dinamita.CatalogoPeliculas.modelo.Proveedor;

import java.io.*;
import java.util.List;

public class PeliculaServicioArchivo implements IPeliculaServicio{
    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public PeliculaServicioArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);

        try{
            if(archivo.exists()){
                System.out.println("El archivo ya existe.");
            }else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error al imprimir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();
            int indice = 0;
            boolean encontrada = false;
            while (lineaTexto != null) {
                // Dividir la línea en partes usando un delimitador apropiado, como ","
                String[] partes = lineaTexto.split(","); // suponiendo que el formato es nombrePelicula,proveedor

                System.out.println("Película encontrada: ID:" + partes[0].trim() + ", Titulo: "
                        + partes[1].trim()+ ", Director: " + partes[2].trim()
                        + ", Duracion: " + partes[3].trim() + ", Genero: " + partes[4].trim()
                        + ", Lanzamiento: " + partes[5].trim() + ", Proveedor:" + partes[6].trim()
                        + ", Origen: " + partes[7].trim());

                lineaTexto = entrada.readLine(); // leer la siguiente línea
                indice++;
                encontrada = true;
            }
            if (!encontrada) {
                System.out.println("No se encontraron películas");
            }
            System.out.println("Se encontraron " + indice + " peliculas!");
            entrada.close(); // Cerrar el BufferedReader cuando hayas terminado
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo no encontrado: " + NOMBRE_ARCHIVO, e);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + NOMBRE_ARCHIVO, e);
        }
    }



    @Override
    public void buscarPeliculaPorProveedor(String proveedor) {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();
            boolean encontrada = false;
            int indice = 0;
            String peliculaProveedor = proveedor;

            while (lineaTexto != null) {
                // Dividir la línea en partes usando un delimitador apropiado, como ","
                String[] partes = lineaTexto.split(","); // suponiendo que el formato es nombrePelicula,proveedor
                // Verificar si el proveedor coincide
                if (partes.length >= 2 && partes[6].trim().equals(peliculaProveedor)) {
                    // Si el proveedor coincide, puedes hacer algo con la película, como imprimir su nombre
                    System.out.println("Película encontrada: ID:" + partes[0].trim() + ", "
                            + " Titulo: " + partes[1].trim()
                            + ", " + " Proveedor:" + partes[6].trim());
                    encontrada = true;
                    indice++;
                }
                lineaTexto = entrada.readLine(); // leer la siguiente línea
            }
            if (!encontrada) {
                System.out.println("No se encontraron películas del proveedor: " + peliculaProveedor);
            }
            System.out.println("Se encontraron " + indice + " peliculas!");
            entrada.close(); // Cerrar el BufferedReader cuando hayas terminado
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo no encontrado: " + NOMBRE_ARCHIVO, e);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + NOMBRE_ARCHIVO, e);
        }
    }


    @Override
    public void guardarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //1. Revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //2. Agregamos la pelicula (toString)
            salida.println(pelicula);
            //3. Cerramos el archivo
            salida.close();
            System.out.println("Pelicula agregada correctamente: " + pelicula);

        } catch (Exception e) {
            System.out.println("Ocurrio un error al agregar pelicula: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPelicula(String peliculaId) {
        File archivoEntrada = new File(NOMBRE_ARCHIVO);
        File archivoTemp = new File("temp.txt"); // Archivo temporal para escribir las líneas no eliminadas
        boolean peliculaEncontrada = false; // Variable para indicar si se encontró la película

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando un delimitador apropiado, como ","
                String[] partes = linea.split(","); // suponiendo que el formato es idPelicula,nombrePelicula,proveedor
                String id = partes[0].trim();
                // Verificar si el ID coincide con el de la película que queremos eliminar
                if (id.equals(peliculaId)) {
                    // Si coincide, marcar la película como encontrada y continuar con la siguiente línea
                    peliculaEncontrada = true;
                    continue;
                }
                // Si no coincide, escribe la línea en el archivo temporal
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el temporal
        archivoEntrada.delete(); // Eliminar el archivo original
        archivoTemp.renameTo(archivoEntrada); // Renombrar el archivo temporal

        // Imprimir el mensaje correspondiente según si se encontró la película o no
        if (peliculaEncontrada) {
            System.out.println("Pelicula eliminada con exito.");
        } else {
            System.out.println("Pelicula no encontrada.");
        }
    }

}
