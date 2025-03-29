package cl.veterinary.cloudbfforchestrator.service.impl;

import cl.veterinary.cloudbfforchestrator.client.UserFunctionClient;
import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.OrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrchestratorServiceImpl implements OrchestratorService {

    @Autowired
    UserFunctionClient userFunctionClient;


    @Override
    public List<User> findAllUser() {
        return userFunctionClient.getUserAll();
    }

    @Override
    public User findUserById(Long id) {
        try {
            Optional<User> userOpt = userFunctionClient.findUserById(id);
            return userOpt.orElseGet(User::new);
        } catch (Exception ex) {

            return new User();
        }
    }

    @Override
    public User saveUser(User user) {
        return userFunctionClient.saveUser(user);
    }

    @Override
    public User updateUser(Long id,User user) {
        return userFunctionClient.updateUser(id,user);
    }

    @Override
    public String deleteUser(Long id) {
        return userFunctionClient.deteleUser(id);
    }

}
