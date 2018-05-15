package apisw.planeta;

public class ListaPlanetaSWAPI {

    private int count;
    private String next;
    private String previous;
    private PlanetaSWAPI[] results;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }
    public String getPrevious() {
        return previous;
    }
    public void setPrevious(String previous) {
        this.previous = previous;
    }
    public PlanetaSWAPI[] getResults() {
        return results;
    }
    public void setResults(PlanetaSWAPI[] results) {
        this.results = results;
    }
    
    
}
