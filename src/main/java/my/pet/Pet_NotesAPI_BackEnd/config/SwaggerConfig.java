package my.pet.Pet_NotesAPI_BackEnd.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .servers(
                        List.of(
                                new Server()
                                        .url("http://denchik2376.fvds.ru/Pet-NotesAPI-BackEnd")
                                        .description("Production")
                        )
                )
                .info(
                        new Info()
                                .title("Notes API")
                                .version("1.0.0")
                );
    }

}
