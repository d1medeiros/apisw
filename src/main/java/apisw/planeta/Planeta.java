package apisw.planeta;

import org.springframework.data.annotation.Id;

public class Planeta {

    @Id
    private Integer id;

    private String nome;
    private String clima;
    private String terreno;
    private int aparicoesPorFilme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getAparicoesPorFilme() {
        return aparicoesPorFilme;
    }

    public void setAparicoesPorFilme(int aparicoesPorFilme) {
        this.aparicoesPorFilme = aparicoesPorFilme;
    }

}
