
package Almacen;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Almacen")
public class Almacen {

    @WebMethod(operationName = "obtenerUnidadesDisponibles")
    public int obtenerUnidadesDisponibles(@WebParam(name = "producto") String producto) {
        // TODO: Obtener de la base de datos
        return 10;
    }
    
    @WebMethod(operationName = "obtenerPrecioUnitario")
    public double obtenerPrecioUnitario(@WebParam(name = "producto") String producto) {
        // TODO: Obtener de la base de datos
        return 10.00;
    }
    
    @WebMethod(operationName = "obtenerPrecioTotal")
    public double obtenerPrecioTotal(@WebParam(name = "producto") String producto,
                                     @WebParam(name = "unidades") int unidades) {
        if (unidades <= obtenerUnidadesDisponibles(producto))
            return obtenerPrecioUnitario(producto) * (double) unidades;
        else
            return -1;
    }
}
