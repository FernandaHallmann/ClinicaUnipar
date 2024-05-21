package br.unipar.programacaointernet.clinica.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(
            new Info().title("Clínica Unipar - Rest API").description("API para agendamento de consultas").version("1.0")
    ).externalDocs(
            new ExternalDocumentation().description("Unipar").url("http://www.unipar.br")
    );
  }
}
