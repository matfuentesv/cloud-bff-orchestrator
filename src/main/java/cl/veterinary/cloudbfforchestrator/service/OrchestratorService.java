package cl.veterinary.cloudbfforchestrator.service;

import cl.veterinary.cloudbfforchestrator.model.User;

import java.util.List;

public interface OrchestratorService {

    List<User>findAllUser();
    User findUserById(Long id);
}
