package hackathon.nttdata.coderpath.examenes.service.examenesrouter;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;

import javax.ws.rs.GET;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
	
	@Bean
	public RouterFunction<ServerResponse> rutas(PreguntaHandler handler){
		return route(GET("/webclient"), handler::listar)
				.andRoute(GET("/webclient/{id}"), handler::getOne)
				.andRoute(POST("/webclient/create-cursos"), handler::save)
        		.andRoute(PUT("/webclient/update-cursos/{id}"), handler::update)
        		.andRoute(DELETE("/webclient/delete-cursos/{id}"), handler::delete);
		
		
		
	}

}
