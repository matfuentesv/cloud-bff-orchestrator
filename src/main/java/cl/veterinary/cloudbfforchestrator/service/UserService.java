package cl.veterinary.cloudbfforchestrator.service;

import cl.veterinary.cloudbfforchestrator.model.User;

import java.util.List;

public interface UserService {

    List<User>findAllUserRest();
    User findUserByIdRest(Long id);
    User saveUserRest(User user);
    User updateUserRest(Long id,User user);
    String deleteUserRest(Long id);

    List<User>findAllUserGraphQl();
    User findUserByIdGraphQl(Long id);
    User saveUserGraphQl(User user);
    User updateUserGraphQl(Long id,User user);
    String deleteUserGraphQl(Long id);

}
