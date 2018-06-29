<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="skel.css" />
        <link rel="stylesheet" href="style.css" />
        <title>Tienda</title>
    </head>
    <body>
        <h1>Productos disponibles</h1>
        <p>Gracias por su visita. Esperamos que encuentre lo que busca.</p>
        <table>
            <tr>
                <th width="33%">Producto</th>
                <th width="33%">Precio</th>
                <th width="33%">Unidades</th>
            </tr>
            <!-- TODO: Usar datos de BDs -->
            <tr>
                <td>Producto 1</td>
                <td>$ 500.00 </td>
                <td>2<td>
            </tr>
            <tr>
                <td>Producto 2</td>
                <td>$ 250.00 </td>
                <td>3<td>
            </tr>
        </table>
        <h2>Para comprar elige un producto y una cantidad</h2>
        <form action="tarjeta.jsp">
            <!-- TODO: Usar datos de BDs -->
            <b>Producto</b>
            <select name="producto">
                <option value="Producto 1">Producto 1</option>
                <option value="Producto 2">Producto 2</option>
                <option value="Producto 3">Producto 3</option>
            </select>
            <b>Cantida:</b>
            <input type="number" name="cantidad" value="1"/> &nbsp;
            <input type="submit" value="Siguiente">
        </form>
    </body>
</html>
