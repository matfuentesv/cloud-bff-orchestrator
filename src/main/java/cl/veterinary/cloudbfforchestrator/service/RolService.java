package cl.veterinary.cloudbfforchestrator.service;



import cl.veterinary.cloudbfforchestrator.model.Rol;

import java.util.List;

public interface RolService {

    List<Rol> findAllRol();
    Rol findRolById(Long id);
    Rol saveRol(Rol rol);
    Rol updateRol(Long id,Rol rol);
    String deleteRol(Long id);

}
