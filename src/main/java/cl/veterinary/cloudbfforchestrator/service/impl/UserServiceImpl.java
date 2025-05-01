package cl.veterinary.cloudbfforchestrator.service.impl;

import cl.veterinary.cloudbfforchestrator.client.UserFunctionClient;
import cl.veterinary.cloudbfforchestrator.client.UserGraphQLClient;
import cl.veterinary.cloudbfforchestrator.model.GraphQLRequest;
import cl.veterinary.cloudbfforchestrator.model.GraphQLResponse;
import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserFunctionClient userFunctionClient;

    @Autowired
    private UserGraphQLClient userGraphQLClient;


    @Override
    public List<User> findAllUserRest() {
        return userFunctionClient.getUserAll();
    }

    @Override
    public User findUserByIdRest(Long id) {
        try {
            Optional<User> userOpt = userFunctionClient.findUserById(id);
            return userOpt.orElseGet(User::new);
        } catch (Exception ex) {

            return new User();
        }
    }

    @Override
    public User saveUserRest(User user) {
        return userFunctionClient.saveUser(user);
    }

    @Override
    public User updateUserRest(Long id,User user) {
        return userFunctionClient.updateUser(id,user);
    }

    @Override
    public String deleteUserRest(Long id) {
        return userFunctionClient.deteleUser(id);
    }

    @Override
    public List<User> findAllUserGraphQl() {
        String query = "{ findAll { id nombre apellidoPaterno apellidoMaterno rut direccion celular email password activo } }";
        GraphQLRequest request = new GraphQLRequest(query);
        ResponseEntity<GraphQLResponse> response = userGraphQLClient.executeQuery(request);
        return Objects.requireNonNull(response.getBody()).getData().getFindAll();
    }

    @Override
    public User findUserByIdGraphQl(Long id) {
        String query = String.format("query { findUserById(id: \"%d\") { id nombre apellidoPaterno apellidoMaterno rut direccion celular email password activo } }", id);
        GraphQLRequest request = new GraphQLRequest(query);

        ResponseEntity<GraphQLResponse> response = userGraphQLClient.executeQuery(request);
        return response.getBody().getData().getFindUserById();
    }

    @Override
    public User saveUserGraphQl(User user) {

            String query = String.format("""
            mutation {
              saveUser(input: {
                id: \"%d\",
                nombre: \"%s\",
                apellidoPaterno: \"%s\",
                apellidoMaterno: \"%s\",
                rut: \"%s\",
                direccion: \"%s\",
                celular: \"%s\",
                email: \"%s\",
                password: \"%s\",
                activo: %s,
                rol: { id: \"%d\" }
              }) {
                id
                nombre
                apellidoPaterno
                apellidoMaterno
                rut
                direccion
                celular
                email
                password
                activo
                rol {
                  id
                  nombre
                  descripcion
                }
              }
            }
            """,
                    user.getId() != null ? user.getId() : 0,
                    user.getNombre(),
                    user.getApellidoPaterno(),
                    user.getApellidoMaterno(),
                    user.getRut(),
                    user.getDireccion(),
                    user.getCelular(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getActivo() != null && user.getActivo(),
                    user.getRol().getId()
            );

            GraphQLRequest request = new GraphQLRequest(query);

            ResponseEntity<GraphQLResponse> response = userGraphQLClient.executeQuery(request);

            return response.getBody().getData().getSaveUser();


    }

    @Override
    public User updateUserGraphQl(Long id, User user) {

            user.setId(id);
            String query = String.format("""
            mutation {
              updateUser(input: {
                id: \"%d\",
                nombre: \"%s\",
                apellidoPaterno: \"%s\",
                apellidoMaterno: \"%s\",
                rut: \"%s\",
                direccion: \"%s\",
                celular: \"%s\",
                email: \"%s\",
                password: \"%s\",
                activo: %s,
                rol: { id: \"%d\" }
              }) {
                id
                nombre
                apellidoPaterno
                apellidoMaterno
                rut
                direccion
                celular
                email
                password
                activo
                rol {
                  id
                  nombre
                  descripcion
                }
              }
            }
            """,
                    id,
                    user.getNombre(),
                    user.getApellidoPaterno(),
                    user.getApellidoMaterno(),
                    user.getRut(),
                    user.getDireccion(),
                    user.getCelular(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getActivo() != null && user.getActivo(),
                    user.getRol().getId()
            );

            GraphQLRequest request = new GraphQLRequest(query);

            ResponseEntity<GraphQLResponse> response = userGraphQLClient.executeQuery(request);

            return response.getBody().getData().getUpdateUser();

    }

    @Override
    public String deleteUserGraphQl(Long id) {
        String query = String.format("""
            mutation {
              deleteUser(id: "%d")
            }
            """, id);

        GraphQLRequest request = new GraphQLRequest(query);
        ResponseEntity<GraphQLResponse> response = userGraphQLClient.executeQuery(request);
        return response.getBody().getData().getDeleteUser();
    }

}
