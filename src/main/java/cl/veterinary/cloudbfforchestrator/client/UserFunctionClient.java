package cl.veterinary.cloudbfforchestrator.client;

import cl.veterinary.cloudbfforchestrator.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "userFunctionClient", url = "${azure.functions.user.base-url}")

public interface UserFunctionClient {

    @GetMapping(value = "/api/findAllUser?code=1KL5zzdbAmDo8if_5TVFd7pOhI22mO5UulQOzlq1j2crAzFu5WLm9Q==",produces = "application/json")
    List<User> getUserAll();

    @GetMapping(value = "/api/findUserById/{id}?code=udIwPBCkWQ3KqPLF7N7AyfQevGyaHBKwX-RuiGTjNVtsAzFugg-8-w==",produces = "application/json")
    Optional<User> findUserById(@PathVariable("id") Long id);
}

