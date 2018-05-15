package apisw;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import apisw.planeta.ListaPlanetaSWAPI;
import apisw.planeta.Planeta;
import apisw.planeta.PlanetaRepository;
import apisw.planeta.PlanetaSWAPI;

@SpringBootApplication
public class ApiswApplication implements CommandLineRunner{

    @Autowired
    private PlanetaRepository planetaRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(ApiswApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        
        Planeta planeta = new Planeta();
        planeta.setId(1);
        planeta.setClima("clima");
        planeta.setNome("nome");
        planeta.setTerreno("terreno");
        
       
        planetaRepository.save(planeta);
        
        planeta = new Planeta();
        planeta.setId(2);
        planeta.setClima("clima 2");
        planeta.setNome("nome 2");
        planeta.setTerreno("terreno 2");
        
        planetaRepository.save(planeta);
        
    }
}
