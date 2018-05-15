package apisw.planeta;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping("/api/planetas")
    public List<Planeta> getTodosPlaneta() {
        return planetaService.buscaTodos();
    }

    @GetMapping("/api/planeta")
    public Planeta getPlanetaPorNome(@RequestParam(name = "nome", required = true) String nome) {
        return planetaService.buscaPorNome(nome);
    }

    @GetMapping("/api/planeta/{id}")
    public Planeta getPlanetaPorId(@PathVariable("id") Integer id){
        return planetaService.buscaPorId(id);
    }

    @PostMapping("/api/planeta")
    public void getPlanetaPorId(@Valid Planeta planeta) throws Exception {
        planetaService.adiciona(planeta);
    }

    @DeleteMapping("/api/planeta/{id}")
    public void removePorId(@PathVariable("id") Integer id) {
        planetaService.removePorId(id);
    }
}
