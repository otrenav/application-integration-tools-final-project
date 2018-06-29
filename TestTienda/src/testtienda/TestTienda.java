
package testtienda;

public class TestTienda {

    public static void main(String[] args) {
        String resultado = tiendaOperation("Pantalla", "1111-2222-3333-4444", 100);
        System.out.println(resultado);
    }

    private static String tiendaOperation(java.lang.String producto, java.lang.String tarjeta, int unidades) {
        org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaService service = new org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaService();
        org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaPortType port = service.getTiendaPort();
        return port.tiendaOperation(producto, tarjeta, unidades);
    }
    
    // TODO: Hacer lo de las deltas para pruebas de estrés
}