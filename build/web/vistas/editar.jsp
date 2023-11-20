<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@page import="modelos.Estudiante"%>
<%@page import="modeloDAO.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="encabezado.jsp" %>
    </head>
    <body>
        <%
            EstudianteDAO dao = new EstudianteDAO();
            String temp = request.getAttribute("idEstudiante").toString();
            int idEstudiante = Integer.parseInt(temp);
            Estudiante est = dao.Listar(idEstudiante);                        
            
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            String fecha = "";
            if(est.getFechaNac() != null){
                fecha = ft.format(est.getFechaNac());
            }            
        %>        
        <div class="container">
            <h1>Editar Estudiante</h1>
            <form action="EstudianteControlador">
                <input type="hidden" name="idEstudiante" value="<%= est.getIdEstudiante()%>" class="form-control">
                <br>
                Nombre:<br>
                <input type="text" name="nombre" value="<%= est.getNombre() %>" class="form-control">

                <br>
                Apellido1:<br>
                <input type="text" name="apellido1" value="<%= est.getApellido1() %>" class="form-control">

                <br>
                Apellido2:<br>
                <input type="text" name="apellido2" value="<%= est.getApellido2() %>" class="form-control">

                <br>
                Cédula:<br>
                <input type="text" name="cedula" value="<%= est.getCedula()%>" class="form-control">

                <br>
                Carnet:<br>
                <input type="text" name="carnet" value="<%= est.getCarnet()%>" class="form-control">

                <br>
                Fecha Nac:<br>                
                <input type="date" name="fechaNac" value="<%= fecha %>" class="form-control"/>                                
                <br>                
                <input type="submit" name="accion" value="actualizar" class="btn btn-primary form-control">
            </form>
        </div>
    </body>
</html>
