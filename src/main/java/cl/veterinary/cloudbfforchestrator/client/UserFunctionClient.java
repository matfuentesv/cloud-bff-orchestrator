package cl.veterinary.cloudbfforchestrator.client;

import cl.veterinary.cloudbfforchestrator.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "userFunctionClient", url = "${azure.functions.user.base-url}")

public interface UserFunctionClient {

    @GetMapping(value = "/api/findAllUser?code=1KL5zzdbAmDo8if_5TVFd7pOhI22mO5UulQOzlq1j2crAzFu5WLm9Q==",produces = "application/json")
    List<User> getUserAll();

    @GetMapping(value = "/api/findUserById/{id}?code=udIwPBCkWQ3KqPLF7N7AyfQevGyaHBKwX-RuiGTjNVtsAzFugg-8-w==",produces = "application/json")
    Optional<User> findUserById(@PathVariable("id") Long id);

    @PostMapping(value = "/api/saveUser?code=gHUv19X0MR43yg51iOfPIQL_Poff-OQHU_MNitcANPOvAzFuStGdWA==",produces = "application/json")
    User saveUser(@RequestBody User body);

    @PutMapping(value = "/api/updateUser/{id}?code=Ppmb9qiqeo5s9OpzPTcINPSn6mqgjaYsJSZwcw9KoVUGAzFud6zpgA==",produces = "application/json")
    User updateUser(@PathVariable("id") Long id,@RequestBody User body);

    @DeleteMapping(value = "/api/deleteUser/{id}?code=DMBRjnpkLxf3eEhWr59teJVrUDygB33KloNmdtv4hlhwAzFuI3Omlw==",produces = "application/json")
    String deteleUser(@PathVariable("id") Long id);
}

