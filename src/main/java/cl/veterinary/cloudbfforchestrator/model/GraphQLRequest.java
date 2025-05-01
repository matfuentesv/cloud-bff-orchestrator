package cl.veterinary.cloudbfforchestrator.model;

public class GraphQLRequest {

    private String query;

    public GraphQLRequest(String query) {
        this.query = query;
    }

    // getter y setter
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
