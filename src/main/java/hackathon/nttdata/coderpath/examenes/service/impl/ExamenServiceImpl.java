package hackathon.nttdata.coderpath.examenes.service.impl;

import java.util.Map;



import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import hackathon.nttdata.coderpath.examenes.repository.ExamenRepository;
import hackathon.nttdata.coderpath.examenes.config.ApplicationConfiguration;
import hackathon.nttdata.coderpath.examenes.document.Examen;
import hackathon.nttdata.coderpath.examenes.document.dtowebclient.Preguntas;
import hackathon.nttdata.coderpath.examenes.service.ExamenService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ExamenServiceImpl implements ExamenService {
	
	private final ExamenRepository ExamenRepository;
	
	private final ApplicationConfiguration configuration;

	@Override
	public Mono<Examen> findById(String id) {
		// TODO Auto-generated method stub
		return ExamenRepository.findById(id);
	}

	@Override
	public Flux<Examen> findAlls() {
		// TODO Auto-generated method stub
		return ExamenRepository.findAll();
	}



	@Override
	public Map<String, Object> balanceadorTest() {
		// TODO Auto-generated method stub
		Map<String, Object> response = Maps.newHashMap();
		response.put("balanceador", configuration.getBalanceadorTest());
		response.put("examen_asset", findAlls());
		return response;
	}

	@Override
	public Mono<Examen> saves(Examen document) {
		// TODO Auto-generated method stub
		return ExamenRepository.save(document);
	}

	@Override
	public Mono<Void> delete(Examen document) {
		// TODO Auto-generated method stub
		return ExamenRepository.delete(document);
	}

	@Override
	public Flux<Preguntas> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Preguntas> findPreguntasById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Preguntas> save(Preguntas document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Preguntas> update(Preguntas document, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> rutaWebClientTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Examen> saveExamenesCurso(Examen document, String examenId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
