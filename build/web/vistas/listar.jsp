<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="modeloDAO.EstudianteDAO"%>
<%@page import="modelos.Estudiante"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="encabezado.jsp" %>
    </head>
    <body>        
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Lista Estudiantes</h1>
                    <table border="1" class="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Apellido1</th>
                                <th>Apellido2</th>
                                <th>Cédula</th>
                                <th>Carnet</th>
                                <th>Fecha Nacimiento</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <%
                            EstudianteDAO dao=new EstudianteDAO();
                            List<Estudiante> lista = dao.Listar();
                            Iterator<Estudiante>iter=lista.iterator();
                            Estudiante est=null;
                            while(iter.hasNext()) {
                                est=iter.next();
                                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                                String fechaNac = "";
                                if(est.getFechaNac() != null){
                                    fechaNac = ft.format(est.getFechaNac());
                                }            
                                
                        %>
                        <tbody>
                            <tr>
                                <td> <%= est.getIdEstudiante()%> </td>
                                <td> <%= est.getNombre() %> </td>
                                <td> <%= est.getApellido1() %></td>
                                <td> <%= est.getApellido2() %></td>
                                <td> <%= est.getCedula()%></td>
                                <td> <%= est.getCarnet()%></td>
                                <td> <%= fechaNac %></td>
                                <td>
                                    <a href="EstudianteControlador?accion=editar&idEstudiante=<%= est.getIdEstudiante()%>">Editar</a>                        
                                    <a href="EstudianteControlador?accion=eliminar&idEstudiante=<%= est.getIdEstudiante()%>">Borrar</a>                        
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
