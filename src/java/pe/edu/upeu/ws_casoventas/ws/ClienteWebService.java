/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.ws_casoventas.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.ws_casoventas.dao.ClienteDao;
import pe.edu.upeu.ws_casoventas.daoImp.ClienteDaoImpl;
import pe.edu.upeu.ws_casoventas.model.Cliente;

/**
 *
 * @author CAMPOS
 */
@WebService(serviceName = "ClienteWebService")
public class ClienteWebService {
ClienteDao clienteDao = new ClienteDaoImpl();

    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "nombre") String nombre, 
                        @WebParam(name = "apellidos") String apellidos, 
                        @WebParam(name = "dni") String dni) {
        return clienteDao.create(new Cliente(0,nombre, 
                                               apellidos, 
                                               dni));
    }

    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "idcliente") int idcliente, 
                      @WebParam(name = "nombre") String nombre, 
                      @WebParam(name = "apellidos") String apellidos, 
                      @WebParam(name = "dni") String dni) {
        return clienteDao.update(new Cliente(idcliente,
                                             nombre,
                                             apellidos,
                                             dni));
    }

    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "id") int id) {
        return clienteDao.delete(id);
    }

    @WebMethod(operationName = "read")
    public Cliente read(@WebParam(name = "id") int id) {
        return clienteDao.read(id);
    }

    @WebMethod(operationName = "readAll")
    public List readAll() {
        return readAll();
    }
    
    



   








}
