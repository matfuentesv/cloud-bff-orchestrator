package cl.veterinary.cloudbfforchestrator.service.impl;

import cl.veterinary.cloudbfforchestrator.client.RolFunctionClient;
import cl.veterinary.cloudbfforchestrator.client.RolGraphQLClient;
import cl.veterinary.cloudbfforchestrator.model.GraphQLRequest;
import cl.veterinary.cloudbfforchestrator.model.GraphQLRolResponse;
import cl.veterinary.cloudbfforchestrator.model.Rol;
import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.RolService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolFunctionClient rolFunctionClient;

    @Autowired
    private RolGraphQLClient graphQLClient;


    @Override
    public List<Rol> findAllRolRest() {
        return rolFunctionClient.getRolAll();
    }

    @Override
    public Rol findRolByIdRest(Long id) {
        try {
            Optional<Rol> rolOpt = rolFunctionClient.findRolById(id);
            return rolOpt.orElseGet(Rol::new);
        } catch (Exception ex) {
            return new Rol();
        }
    }

    @Override
    public Rol saveRolRest(Rol rol) {
        return rolFunctionClient.saveRol(rol);
    }

    @Override
    public Rol updateRolRest(Long id, Rol rol) {
        return rolFunctionClient.updateRol(id,rol);
    }

    @Override
    public String deleteRolRest(Long id) {
        return rolFunctionClient.deteleRol(id);
    }

    @Override
    public List<Rol> findAllRolGraphQL() {


            String query = "{ getAllRoles { id nombre descripcion } }";
            GraphQLRequest request = new GraphQLRequest(query);
            ResponseEntity<GraphQLRolResponse> response = graphQLClient.executeQuery(request);
            return Objects.requireNonNull(response.getBody()).getData().getGetAllRoles();

    }

    @Override
    public Rol findRolByIdGraphQL(Long id) {

        String query = String.format("query { getRolById(id: \"%d\") { id nombre descripcion } }", id);
        GraphQLRequest request = new GraphQLRequest(query);


        ResponseEntity<GraphQLRolResponse> response = graphQLClient.executeQuery(request);
        return response.getBody().getData().getGetRolById();
    }

    @Override
    public Rol saveRolGraphQL(Rol rol) {


            String query = String.format("""
            mutation {
              saveRol(input: {
                nombre: "%s",
                descripcion: "%s"
              }) {
                id
                nombre
                descripcion
              }
            }
            """, rol.getNombre(), rol.getDescripcion());

            GraphQLRequest request = new GraphQLRequest(query);


            ResponseEntity<GraphQLRolResponse> response = graphQLClient.executeQuery(request);
            return response.getBody().getData().getSaveRol();
    }

    @Override
    public Rol updateRolGraphQL(Long id, Rol rol) {

            String query = String.format("""
            mutation {
              updateRol(input: {
                id: "%d",
                nombre: "%s",
                descripcion: "%s"
              }) {
                id
                nombre
                descripcion
              }
            }
            """, id, rol.getNombre(), rol.getDescripcion());

            GraphQLRequest request = new GraphQLRequest(query);

            ResponseEntity<GraphQLRolResponse> response = graphQLClient.executeQuery(request);
            return response.getBody().getData().getUpdateRol();
    }

    @Override
    public String deleteRolGraphQL(Long id) {

            // 1. Construir la mutación
            String query = String.format("""
            mutation {
              deleteRol(id: "%d")
            }
            """, id);

            GraphQLRequest request = new GraphQLRequest(query);
            ResponseEntity<GraphQLRolResponse> response = graphQLClient.executeQuery(request);
            return response.getBody().getData().getDeleteRol();

    }


}
