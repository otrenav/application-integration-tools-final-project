
public class TiendaApp {

    private static String tiendaOperation(java.lang.String producto, java.lang.String tarjeta, int unidades) {
        org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaService service = new org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaService();
        org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaPortType port = service.getTiendaPort();
        return port.tiendaOperation(producto, tarjeta, unidades);
    }
}
