package apisw;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import apisw.planeta.ListaPlanetaSWAPI;
import apisw.planeta.Planeta;
import apisw.planeta.PlanetaRepository;
import apisw.planeta.PlanetaSWAPI;

@SpringBootApplication
public class ApiswApplication {

    
    public static void main(String[] args) {
        SpringApplication.run(ApiswApplication.class, args);
    }
    
}
