package pe.edu.upeu.ws_casoventas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author CAMPOS
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cliente {
    private int idcliente;
    private String nombre;
    private String apellidos;
    private String dni;
}
