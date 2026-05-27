package ar.edu.unpaz.rotiseria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador MVC de la pagina principal.
 *
 * No devuelve datos JSON. Redirige la raiz del sitio hacia el archivo
 * estatico {@code index.html} ubicado en {@code src/main/resources/static}.
 */
@Controller
public class HomeController {

	/**
	 * Atiende la raiz de la aplicacion web.
	 *
	 * @return instruccion de forward para mostrar la pagina principal
	 */
	@GetMapping("/")
	public String inicio() {
		return "forward:/index.html";
	}
}

