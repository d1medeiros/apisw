package apisw.planeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    public List<Planeta> buscaTodos() {
        List<Planeta> listaPlanetas = new ArrayList<>();
        planetaRepository.findAll().forEach(planeta -> listaPlanetas.add(planeta));
        return listaPlanetas;
    }

    public Planeta buscaPorNome(String nome) {
        Planeta planeta = planetaRepository.findByNome(nome);
        return planeta;
    }

    public Planeta buscaPorId(Integer id) {
        Optional<Planeta> possivelPlaneta = planetaRepository.findById(id);
        return possivelPlaneta.get();
    }

    public void adiciona(Planeta planeta) {
        
        getPlanetaPorFilme(planeta);
        
//        planetaRepository.save(planeta);
    }

    private void getPlanetaPorFilme(Planeta planeta) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

//            ResponseEntity<PlanetaSWAPI[]> exchange = restTemplate.exchange("https://swapi.co/api/planets/", HttpMethod.GET,entity,PlanetaSWAPI[].class);
            ResponseEntity<PlanetaSWAPI[]> exchange = restTemplate.getForEntity("https://swapi.co/api/planets/", PlanetaSWAPI[].class);
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
        
    }

    public void removePorId(Integer id) {
        planetaRepository.deleteById(id);
    }

}
