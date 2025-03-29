package cl.veterinary.cloudbfforchestrator.client;

import cl.veterinary.cloudbfforchestrator.model.Rol;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "rolFunctionClient", url = "${azure.functions.rol.base-url}")
public interface RolFunctionClient {

    @GetMapping(value = "/api/findAllRol?code=Xs-JIMFCqNa4kM2HXxEjozI28rDz7ixbNtUpBZEfBLKLAzFuSlb0xA==",produces = "application/json")
    List<Rol> getRolAll();

    @GetMapping(value = "/api/findRolesById/{id}?code=ZEIVh95P6n7ShIh-dc8QoNQQvjNhq-p286gEm33LO5A3AzFu0REtHg==",produces = "application/json")
    Optional<Rol> findRolById(@PathVariable("id") Long id);

    @PostMapping(value = "/api/saveRoles?code=GhrUSBN-WzPMBACDiCy9potwj65iYD9t9OOe-NKIINc6AzFuAg6flQ==",produces = "application/json")
    Rol saveRol(@RequestBody Rol body);

    @PutMapping(value = "api/updateRoles/{id}?code=n0454PCbOeLICwiNuX7xHx5oUJYHpRWKQxDRCV_By8fhAzFur2_C5g==",produces = "application/json")
    Rol updateRol(@PathVariable("id") Long id,@RequestBody Rol body);

    @DeleteMapping(value = "api/deleteRoles/{id}?code=WjySsfafJz9Wa7AdzKzbMx-S_KvJda_BgHmVXEQtIDoAAzFuC6ULeA==",produces = "application/json")
    String deteleRol(@PathVariable("id") Long id);

}
