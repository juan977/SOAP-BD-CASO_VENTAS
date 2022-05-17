package pe.edu.upeu.ws_casoventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.ws_casoventas.config.Conexion;
import pe.edu.upeu.ws_casoventas.dao.ClienteDao;
import pe.edu.upeu.ws_casoventas.model.Cliente;

/**
 *
 * @author CAMPOS
 */
public class ClienteDaoImpl implements ClienteDao{
    private PreparedStatement pres;
    private ResultSet res;
    private Connection conn;

    @Override
    public int create(Cliente cliente) {
        String SQL = "INSERT INTO cliente(nombre) VALUES(?)";
        int x = 0;
        try {
            conn = Conexion.getConex();
            pres = conn.prepareStatement(SQL);
            pres.setString(1, cliente.getNombre());
            x = pres.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int update(Cliente cliente) {
        String SQL = "UPDATE cliente SET nombre=? WHERE idcliente=?)";
        int x = 0;
        try {
            conn = Conexion.getConex();
            pres = conn.prepareStatement(SQL);
            pres.setString(1, cliente.getNombre());
            pres.setString(1, cliente.getApellidos());
            pres.setString(1, cliente.getDni());
            pres.setInt(2, cliente.getIdcliente());
            x = pres.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM cliente WHERE idcliente=?";
        int x = 0;
        try {
            conn = Conexion.getConex();
            pres = conn.prepareStatement(SQL);
            pres.setInt(1, id);
            x = pres.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public Cliente read(int id) {
        String SQL = "SELECT *FROM cliente WHERE idcliente=?";
        Cliente cliente = new Cliente();
        try {
            conn = Conexion.getConex();
            pres = conn.prepareStatement(SQL);
            pres.setInt(1, cliente.getIdcliente());
            res = pres.executeQuery();
            while (res.next()) {                
                cliente.setIdcliente(res.getInt("idcliente"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setApellidos(res.getString("apellidos"));
                cliente.setDni(res.getString("dni"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return cliente;
    }

    @Override
    public List<Cliente> readAll() {
        String SQL = "SELECT *FROM cliente";
        List<Cliente>lista = new ArrayList<>();
        try {
            conn = Conexion.getConex();
            pres = conn.prepareStatement(SQL);
            res = pres.executeQuery();
            while (res.next()) {                
                Cliente cliente = new Cliente();
                cliente.setIdcliente(res.getInt("idcliente"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setApellidos(res.getString("apellidos"));
                cliente.setDni(res.getString("dni"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }
}
