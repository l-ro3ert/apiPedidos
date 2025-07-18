package br.com.cotiinformatica.configurations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	OpenAPI customOpenApi() {
		final String securitySchemeName = "bearerAuth";
		return new OpenAPI()
			.components(new Components()
				.addSecuritySchemes(securitySchemeName,
					new SecurityScheme()
						.name(securitySchemeName)
						.type(SecurityScheme.Type.HTTP)
						.scheme("bearer")
						.bearerFormat("JWT")))
			.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
			.info(new Info()
				.title("API de Pedidos - Treinamento")
				.description("Projeto desenvolvido durante o curso **Java Avançado - Formação Arquiteto**.")
				.version("v1.0.0")
				.termsOfService("https://www.empresateste.com.br/termos")
				.contact(new Contact()
					.name("Nome empresa")
					.email("contato@empresateste.com.br")
					.url("https://www.empresateste.com.br"))
				.license(new License()
					.name("Licença MIT")
					.url("https://opensource.org/licenses/MIT")));
	}
	
}

