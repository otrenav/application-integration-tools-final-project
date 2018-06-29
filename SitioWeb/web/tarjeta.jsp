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
            String producto = request.getParameter("producto");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            int unidadesDisponibles;
            try {
                almacen.Almacen_Service service = new almacen.Almacen_Service();
                almacen.Almacen port = service.getAlmacenPort();
                unidadesDisponibles = port.obtenerUnidadesDisponibles(producto);
            } catch (Exception ex) {
                unidadesDisponibles = -1;
            }
        %>

        <%
            if (cantidad <= unidadesDisponibles) {
                double precio;
                double total;
                try {
                    almacen.Almacen_Service service = new almacen.Almacen_Service();
                    almacen.Almacen port = service.getAlmacenPort();
                    precio = port.obtenerPrecioUnitario(producto);
                    total = port.obtenerPrecioTotal(producto, cantidad);
                } catch (Exception ex) {
                    precio = -1;
                    total = -1;
                }
        %>
        
        <h1>Checkout</h1>
        <table>
            <tr>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Total</th>
            </tr>
            <tr>
                <td><%= producto%></td>
                <td><%= precio%></td>
                <td><%= cantidad%></td>
                <td><%= total%></td>
            </tr>
        </table>
        <h2>Ingrese su número de tarjeta</h2>
        <form action="confirmacion.jsp">
            <input type="hidden" name="producto" value="<%= producto%>" readOnly="true"/>
            <input type="hidden" name="cantidad" value="<%= cantidad%>" readOnly="true"/>
            <input type="text" name="tarjeta"/> <br>
            <input type="submit" value="Comprar">
        </form>
        <% } else {%>
        <h1>Atención</h1>
        <p>No hay suficiente unidades en el almacén.</p>
        <p>Solamente hay <%= unidadesDisponibles%> unidades.</p>
        <% }%>
    </body>
</html>
