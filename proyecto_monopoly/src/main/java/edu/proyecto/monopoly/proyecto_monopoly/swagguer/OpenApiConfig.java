package edu.proyecto.monopoly.proyecto_monopoly.swagguer;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                    name = "Alex",
                    email = "alexgar@gmail.com",
                    url = "https://google.com"
                ),
                description = "OpenApi documentation for spring security",
                title = "OpenApi specification - AlexGar",
                version = "1.0",
                license = @License(
                    name = "License Alex",
                    url = "http://pepe.com"
                ),
                termsOfService = "https://ieslluisimarro.org/termsServices" 
        
        ),
        servers = {
                @Server(
                    description = "Local ENV",
                    url = "http://localhost:8090"
                ),
                @Server(
                    description = "Prod ENV",
                    url = "http://alexgarcia/productionAPI"
                ),

        },
        security = {
                @SecurityRequirement(
                    name = "bearerAuth"
                )
        }
)

@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
    
}
