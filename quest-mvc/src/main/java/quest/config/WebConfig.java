package quest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@ComponentScan("quest.controller")
@Configuration
@EnableWebMvc
public class WebConfig {
	
	// Configurer un suffixe et préfixe à ajouter au vues pour la servlet
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver=new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		// On fixe que les vues utilisent les jsp avec la jstl
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

}
