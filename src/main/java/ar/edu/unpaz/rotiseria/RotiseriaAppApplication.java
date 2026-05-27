package ar.edu.unpaz.rotiseria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicacion Spring Boot.
 *
 * Desde esta clase Spring inicia el contexto de la aplicacion, detecta los
 * componentes anotados con {@code @Controller}, {@code @Service} y
 * {@code @Repository}, y levanta el servidor web embebido.
 */
@SpringBootApplication
public class RotiseriaAppApplication {

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args argumentos recibidos desde la linea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(RotiseriaAppApplication.class, args);
	}
}

