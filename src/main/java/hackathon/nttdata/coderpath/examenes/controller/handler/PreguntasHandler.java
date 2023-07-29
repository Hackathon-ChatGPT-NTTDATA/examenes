package hackathon.nttdata.coderpath.examenes.controller.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import hackathon.nttdata.coderpath.examenes.controller.validation.ObjectValidator;
import hackathon.nttdata.coderpath.examenes.document.dtowebclient.Preguntas;
import hackathon.nttdata.coderpath.examenes.service.ExamenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class PreguntasHandler {

	private final ObjectValidator objectValidator;

	@Autowired
	private ExamenService service;

	public Mono<ServerResponse> listar(ServerRequest request) {

		return ServerResponse.ok().contentType(APPLICATION_JSON_UTF8).body(service.findAll(), Preguntas.class);
	}

	public Mono<ServerResponse> getOne(ServerRequest request) {

		String id = request.pathVariable("id");

		return service.findPreguntasById(id).flatMap(c -> ServerResponse.ok().contentType(APPLICATION_JSON_UTF8)
				.syncBody(c).switchIfEmpty(ServerResponse.notFound().build()));
	}

	public Mono<ServerResponse> save(ServerRequest request) {
		Mono<Preguntas> dtoMono = request.bodyToMono(Preguntas.class).doOnNext(objectValidator::validate);
		return dtoMono.flatMap(productDto -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(service.save(productDto), Preguntas.class));
	}

	public Mono<ServerResponse> update(ServerRequest request) {
		String id = request.pathVariable("id");
		Mono<Preguntas> dtoMono = request.bodyToMono(Preguntas.class).doOnNext(objectValidator::validate);
		return dtoMono.flatMap(c -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(service.update(c, id), Preguntas.class));
	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.pathVariable("id");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.delete(id), Preguntas.class);
	}

}
