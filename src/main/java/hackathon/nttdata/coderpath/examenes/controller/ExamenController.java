package hackathon.nttdata.coderpath.examenes.controller;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hackathon.nttdata.coderpath.examenes.document.Examen;
import hackathon.nttdata.coderpath.examenes.service.ExamenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




@RestController
@Slf4j
@RequiredArgsConstructor
public class ExamenController {
	
	private final ExamenService service;
	
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		return ResponseEntity.ok(service.balanceadorTest());
	}
		
	@GetMapping("/all")
	public Flux<Examen> searchAll() {
		Flux<Examen> per = service.findAlls();
		log.info("Examen ASSET registered: " + per);
		return per;
	}
	
	@GetMapping("/id/{id}")
	public Mono<Examen> searchById(@PathVariable String id) {
		log.info("Personal Asset id: " + service.findById(id) + " con codigo: " + id);
		return service.findById(id);
	}
	
	@PostMapping("/create-Examen")
	public Mono<Examen> createExamen(@Valid @RequestBody Examen examenAsset) {
		log.info("Examenes hackathon NTTTDATA create: " + service.saves(examenAsset));
		Mono.just(examenAsset).doOnNext(t -> {

			t.setCreateAt(new Date());

		}).onErrorReturn(examenAsset).onErrorResume(e -> Mono.just(examenAsset))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> log.info(x.toString()));

		Mono<Examen> newPersonalAsset = service.saves(examenAsset);

		return newPersonalAsset;
	}
	
	@PutMapping("/update-examen/{id}")
	public ResponseEntity<Mono<?>> updateExamenAsset(@PathVariable String id, @Valid @RequestBody Examen examenAsset) {
		Mono.just(examenAsset).doOnNext(t -> {
			examenAsset.setId(id);
			t.setCreateAt(new Date());

		}).onErrorReturn(examenAsset).onErrorResume(e -> Mono.just(examenAsset))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> log.info(x.toString()));

		Mono<Examen> pAsset = service.saves(examenAsset);

		if (pAsset != null) {
			return new ResponseEntity<>(pAsset, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Mono.just(new Examen()), HttpStatus.I_AM_A_TEAPOT);
	}
	
	@DeleteMapping("/"
			+ "/{id}")
	public ResponseEntity<Mono<Void>> deleteExamenAsset(@PathVariable String id) {
		Examen examenAsset = new Examen();
		examenAsset.setId(id);
		Mono<Examen> newPersonalAsset = service.findById(id);
		newPersonalAsset.subscribe();
		Mono<Void> test = service.delete(examenAsset);
		test.subscribe();
		return ResponseEntity.noContent().build();
	}
	
}
