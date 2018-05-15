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

        int quantidadePorFilme = getPlanetaPorFilme(planeta);
        planeta.setAparicoesPorFilme(quantidadePorFilme);
        planetaRepository.save(planeta);
    }

    private int getPlanetaPorFilme(Planeta planeta) {
        int quantidadeDeFilmes = 0;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<ListaPlanetaSWAPI> exchange = restTemplate.exchange("https://swapi.co/api/planets/", HttpMethod.GET, entity, ListaPlanetaSWAPI.class);
            ListaPlanetaSWAPI exchangePlanet = exchange.getBody();

            List<PlanetaSWAPI> listaPlanetaSWAPI = Stream.of(exchangePlanet.getResults()).filter(planetaDaApi -> planetaDaApi.getName().equals("Endor")).collect(Collectors.toList());
            if (listaPlanetaSWAPI.size() != 1)
                return -1;

            String[] films = listaPlanetaSWAPI.get(0).getFilms();
            quantidadeDeFilmes = films.length;

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return quantidadeDeFilmes;
    }

    public void removePorId(Integer id) {
        planetaRepository.deleteById(id);
    }

}
