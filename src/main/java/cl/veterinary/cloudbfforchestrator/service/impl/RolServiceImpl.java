package cl.veterinary.cloudbfforchestrator.service.impl;

import cl.veterinary.cloudbfforchestrator.client.RolFunctionClient;
import cl.veterinary.cloudbfforchestrator.model.Rol;
import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolFunctionClient rolFunctionClient;


    @Override
    public List<Rol> findAllRol() {
        return rolFunctionClient.getRolAll();
    }

    @Override
    public Rol findRolById(Long id) {
        try {
            Optional<Rol> rolOpt = rolFunctionClient.findRolById(id);
            return rolOpt.orElseGet(Rol::new);
        } catch (Exception ex) {
            return new Rol();
        }
    }

    @Override
    public Rol saveRol(Rol rol) {
        return rolFunctionClient.saveRol(rol);
    }

    @Override
    public Rol updateRol(Long id, Rol rol) {
        return rolFunctionClient.updateRol(id,rol);
    }

    @Override
    public String deleteRol(Long id) {
        return rolFunctionClient.deteleRol(id);
    }
}
