package cl.veterinary.cloudbfforchestrator.service;



import cl.veterinary.cloudbfforchestrator.model.Rol;

import java.util.List;

public interface RolService {

    List<Rol> findAllRolRest();
    Rol findRolByIdRest(Long id);
    Rol saveRolRest(Rol rol);
    Rol updateRolRest(Long id,Rol rol);
    String deleteRolRest(Long id);

    List<Rol> findAllRolGraphQL();
    Rol findRolByIdGraphQL(Long id);
    Rol saveRolGraphQL(Rol rol);
    Rol updateRolGraphQL(Long id,Rol rol);
    String deleteRolGraphQL(Long id);

}
