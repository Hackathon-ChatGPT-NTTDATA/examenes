package hackathon.nttdata.coderpath.examenes.service;

import java.util.Map;
import hackathon.nttdata.coderpath.examenes.document.Examen;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




public interface ExamenService {
	
	Mono<Examen> findById(String id);

	Flux<Examen> findAlls();

	Mono<Examen> saves(Examen document);

	Mono<Void> delete(Examen document);

	Map<String, Object> balanceadorTest();


}
