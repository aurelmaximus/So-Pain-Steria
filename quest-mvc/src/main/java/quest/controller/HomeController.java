package quest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//La classe va donc gérer des URL
@Controller 
public class HomeController {

	@RequestMapping("/home") // Definition de l'url qui permet d'arriver sur cette méthode qui affiche une VUE. L'URL traitée quoi
	public String home() {
		return "home"; // Voir UrlBasedSolver pour la simplification du chemin et du .jsp
	}
}
