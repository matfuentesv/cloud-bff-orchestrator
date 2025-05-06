package cl.veterinary.cloudbfforchestrator.service.impl;

import cl.veterinary.cloudbfforchestrator.client.RolFunctionClient;
import cl.veterinary.cloudbfforchestrator.client.RolGraphQLClient;
import cl.veterinary.cloudbfforchestrator.client.UserFunctionClient;
import cl.veterinary.cloudbfforchestrator.client.UserGraphQLClient;
import cl.veterinary.cloudbfforchestrator.model.GraphQLRequest;
import cl.veterinary.cloudbfforchestrator.model.GraphQLResponse;
import cl.veterinary.cloudbfforchestrator.model.Rol;
import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.RolService;
import cl.veterinary.cloudbfforchestrator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserFunctionClient userFunctionClient;

    @Autowired
    private UserGraphQLClient userGraphQLClient;

    @Autowired
    RolFunctionClient rolFunctionClient;

    @Autowired
    private RolService rolService;


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
    public User saveUserWithDefaultRoleRest(User user) {
        if (user.getRol() == null || user.getRol().getId() == null) {
            // Buscar el rol por defecto, por nombre o ID
            Rol defaultRol = rolFunctionClient.findRolById(2L)
                    .orElseThrow(() -> new RuntimeException("Rol por defecto no encontrado"));
            user.setRol(defaultRol);
        }

        // Ahora guardar el usuario con el rol ya asignado
        return userFunctionClient.saveUser(user);
    }

    @Override
    public String deleteRolAndUserRest(Long idRol) {

        List<User> allUsers = userFunctionClient.getUserAll();


        List<User> usersWithRol = allUsers.stream()
                .filter(u -> u.getRol() != null && u.getRol().getId().equals(idRol))
                .toList();

        // 3. Obtener rol por defecto alternativo (ej: ID 1)
        Rol defaultRol = new Rol();
        defaultRol.setId(3L);
        defaultRol.setNombre("Default");
        defaultRol.setDescripcion("Rol asignado por defecto al eliminar otro");

        // 4. Reasignar ese rol
        for (User user : usersWithRol) {
            user.setRol(defaultRol);
            userFunctionClient.updateUser(user.getId(), user);
        }

        // 5. Eliminar el rol original
        return rolFunctionClient.deteleRol(idRol);
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

    @Override
    public User saveUserWithDefaultRoleGraphQl(User user) {
        if (user.getRol() == null || user.getRol().getId() == null) {
            // Buscar el rol por defecto, por nombre o ID
            Rol defaultRol = rolService.findRolByIdGraphQL(2L);
            user.setRol(defaultRol);
        }

        // Ahora guardar el usuario con el rol ya asignado
        return userFunctionClient.saveUser(user);
    }



}
