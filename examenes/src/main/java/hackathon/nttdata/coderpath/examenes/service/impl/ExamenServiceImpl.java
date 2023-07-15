package hackathon.nttdata.coderpath.examenes.service.impl;

import java.util.Map;

import com.google.common.collect.Maps;

import hackathon.nttdata.coderpath.examenes.config.ApplicationConfiguration;
import hackathon.nttdata.coderpath.examenes.document.Examen;
import hackathon.nttdata.coderpath.examenes.repository.ExamenRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExamenServiceImpl {
	
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
	public Mono<Examen> saves(examen document) {
		// TODO Auto-generated method stub
		return ExamenRepository.save(document);
	}

	@Override
	public Mono<Void> delete(examen document) {
		// TODO Auto-generated method stub
		return ExamenRepository.delete(document);
	}

	@Override
	public Map<String, Object> balanceadorTest() {
		// TODO Auto-generated method stub
		Map<String, Object> response = Maps.newHashMap();
		response.put("balanceador", configuration.getBalanceadorTest());
		response.put("examen_asset", findAlls());
		return response;
	}
	


}
