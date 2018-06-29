<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="skel.css" />
        <link rel="stylesheet" href="style.css" />
        <title>Tienda</title>
    </head>
    <body>
        <%
            int unidades = Integer.parseInt(request.getParameter("cantidad"));
            String producto = request.getParameter("producto");
            String tarjeta = request.getParameter("tarjeta");
            String resultado = "";
            
            try {
                org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaService service = new org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaService();
                org.netbeans.j2ee.wsdl.tienda.descriptorbpel.tienda.TiendaPortType port = service.getTiendaPort();
                resultado = port.tiendaOperation(producto, tarjeta, unidades);
            } catch (Exception ex) {
                resultado = "<b>Error:</b> por favor intente nuevamente más tarde.";
            }
        %>

        <h1>Resultado de compra</h1>
        <p><%= resultado%></p>
        <a href="productos.jsp">Regresar a lista de productos</a>
    </body>
</html>
