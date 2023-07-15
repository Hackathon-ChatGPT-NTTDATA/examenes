package hackathon.nttdata.coderpath.examenes.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import hackathon.nttdata.coderpath.examenes.document.Examen;

@Repository
public interface ExamenRepository extends ReactiveMongoRepository<Examen, String> {

}
