package apisw.planeta;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetaRepository extends MongoRepository<Planeta, Integer> {

    public Planeta findByNome(String nome);

}
