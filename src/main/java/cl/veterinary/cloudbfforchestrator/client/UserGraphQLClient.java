package cl.veterinary.cloudbfforchestrator.client;

import cl.veterinary.cloudbfforchestrator.model.GraphQLRequest;
import cl.veterinary.cloudbfforchestrator.model.GraphQLResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usergraphqlClient", url = "https://faas-graphql-user.azurewebsites.net")
public interface UserGraphQLClient {

    @PostMapping(value = "/api/graphql", consumes = "application/json")
    ResponseEntity<GraphQLResponse> executeQuery(@RequestBody GraphQLRequest request);

}
