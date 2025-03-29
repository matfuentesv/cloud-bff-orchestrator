package cl.veterinary.cloudbfforchestrator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    private Long id;
    private String nombre;
    private String descripcion;

}
