<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 100px;">
            <h1>Iniciar Sesión</h1>
            <br>
            <div class="row">                
                <div class="col-3">
                    <form action="EstudianteControlador">
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-user"></i></span>
                            <input type="text" name="usuario" class="form-control" placeholder="Usuario" aria-label="Usuario" aria-describedby="basic-addon1">
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-lock"></i></span>
                            <input type="text" name="contrasena" class="form-control" placeholder="Contraseña" aria-label="Contrasena" aria-describedby="basic-addon1">
                        </div>
                        <%
                            String error = request.getAttribute("error").toString();                            
                            if(error != null && !error.equals("")) {
                        %>
                        <p style="color: red">
                           <%= error %>
                        </p>
                        <% } %>
                        <input type="submit" name="accion" value="login" class="btn btn-primary form-control" />
                    </form>
                </div>                
            </div>            
            
        </div>        
    </body>
</html>
