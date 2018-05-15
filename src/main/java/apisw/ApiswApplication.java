package apisw;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


            restTemplate.exchange("https://swapi.co/api/planets/", HttpMethod.GET,entity, new ParameterizedTypeReference <List<PlanetaSWAPI>> () {});
//            restTemplate.exchange("https://swapi.co/api/planets/", HttpMethod.GET,entity,PlanetaSWAPI[].class);
//            List<PlanetaSWAPI> listaPlanetaSWAPI = Stream.of(exchange.getBody())
//                    .filter(planetaDaApi -> planetaDaApi.getName().equals(planeta.getNome()))
//                    .collect(Collectors.toList());
//            
            
//            System.out.println(listaPlanetaSWAPI.size());
//            .findFirst().get();
//            PlanetaSWAPI planetaSWAPI = 
//            int quantidadeDeFilmes = planetaSWAPI.getFilms().size();
            
            
            
        } catch (Exception ex) {
           ex.printStackTrace();

        }
        
        planetaRepository.save(planeta);
        
        planeta = new Planeta();
        planeta.setId(2);
        planeta.setClima("clima 2");
        planeta.setNome("nome 2");
        planeta.setTerreno("terreno 2");
        
        planetaRepository.save(planeta);
        
    }
}
