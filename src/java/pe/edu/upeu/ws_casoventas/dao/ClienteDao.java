package pe.edu.upeu.ws_casoventas.dao;

import java.util.List;
import pe.edu.upeu.ws_casoventas.model.Cliente;

/**
 *
 * @author CAMPOS
 */
public interface ClienteDao {
    
    int create(Cliente cliente);
    int update(Cliente cliente);
    int delete(int id);
    Cliente read(int id);
    List<Cliente> readAll();
}
