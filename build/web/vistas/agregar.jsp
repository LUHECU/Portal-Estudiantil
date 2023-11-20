<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="encabezado.jsp" %>
    </head>
    <body>
        <div class="container">
            <h1>Agregar Estudiante</h1>
            <form action="EstudianteControlador">
                <br>
                Nombre:<br>
                <input type="text" name="nombre" class="form-control" placeholder="Nombre">

                <br>
                Apellido1:<br>
                <input type="text" name="apellido1" class="form-control">

                <br>
                Apellido2:<br>
                <input type="text" name="apellido2" class="form-control">

                <br>
                Cédula:<br>
                <input type="text" name="cedula" class="form-control">

                <br>
                Carnet:<br>
                <input type="text" name="carnet" class="form-control">

                <br>
                Fecha Nac:<br>
                <input type="date" name="fechaNac" class="form-control">

                <br>
                <input type="submit" name="accion" value="guardar" class="btn btn-primary form-control">
            </form>
        </div>
    </body>
</html>
