package cl.veterinary.cloudbfforchestrator.client;

import cl.veterinary.cloudbfforchestrator.model.GraphQLRequest;
import cl.veterinary.cloudbfforchestrator.model.GraphQLRolResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "graphqlClient", url = "https://faas-graphql-rol.azurewebsites.net")
public interface RolGraphQLClient {

    @PostMapping(value = "/api/graphql", consumes = "application/json")
    ResponseEntity<GraphQLRolResponse> executeQuery(@RequestBody GraphQLRequest request);

}
