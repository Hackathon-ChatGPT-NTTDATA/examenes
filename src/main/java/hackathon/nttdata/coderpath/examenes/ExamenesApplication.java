package hackathon.nttdata.coderpath.examenes;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import hackathon.nttdata.coderpath.examenes.document.Examen;
import reactor.core.publisher.Flux;








@EnableEurekaClient
@SpringBootApplication
public class ExamenesApplication implements CommandLineRunner {
	
	private static  final Logger log = LoggerFactory.getLogger(ExamenesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExamenesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("-------------------Ejemplo 1------------------------------------");
		ejemplo1();
		System.out.println("-------------------Ejemplo 1a------------------------------------");
		ejemplo1a();
		System.out.println("-------------------Ejemplo 2------------------------------------");
		ejemplo2();		
	}

	
	public void ejemplo1() {
		Flux<String> examenes = Flux.just("prueba 1" , "prueba 2" , "prueba 3")
				.doOnNext(err ->{ 
					if (err.isEmpty()) {
						throw new RuntimeException("examen no puede ser vacio");
					}
					{System.out.println(err);}});
		examenes.subscribe(err -> log.info(err),
				error -> log.error(error.getMessage()),
				new Runnable() {
					
					@Override
					public void run() {
						log.info("¡se a modificado la excepcion con exito!");
					}});
		}	
	/* subcribsion de un obsevable*/
	public void ejemplo1a() {
		Flux<String> examenes = Flux.just("prueba 1" , "prueba 2" , "prueba 3" , "prueba 4")
				.doOnNext(e->{
		 			if (e.isEmpty()){
		 				throw new RuntimeException("examenes no puede ser vacio");
			 		}{System.out.println(e);}
			 		});
			examenes.subscribe(e -> log.info(e),
					error-> log.error(error.getMessage()));
					} 
		


public void ejemplo2() {
	Flux<Examen> nombres = Flux.just("prueba 1", "prueba 2" , "prueba 3","prueba 4")
			.map(nombre -> new Examen(nombre.toLowerCase(),null, null))
			.doOnNext(examen ->{
				if (examen == null) {
					throw new RuntimeException("examen no puerde ser vacios");
				}
				System.out.println(examen.getNombre());
			})
			.map(examen ->{
				String nombre = examen.getNombre().toLowerCase();
				examen.setNombre(nombre);
				return examen;
			});
	
			nombres.subscribe(e -> log.info(e.getNombre()),
					error -> log.error(error.getMessage()),
					new Runnable() {
						
						@Override
						public void run() {
							log.info("¡se a modificado la excepcion con exito!");
						}
						});
			
}


			



				
			
			
			
			
			



}