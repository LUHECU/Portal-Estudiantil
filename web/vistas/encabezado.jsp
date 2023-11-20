<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Estudiantes</title>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">      
      <a class="navbar-brand" href="EstudianteControlador?accion=inicio"><img src="${pageContext.request.contextPath}/vistas/img/EstuLogo2.jpg" width="50px;" height="50px;" /> </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">       
        <li class="nav-item">
          <a class="nav-link" href="EstudianteControlador?accion=listar">Listar</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="EstudianteControlador?accion=agregar">Agregar</a>
        </li>        
      </ul>
        <%
            HttpSession sesion = request.getSession();
            String usuario = (String)sesion.getAttribute("usuario");
            String nombreUsuario = (String)sesion.getAttribute("nombre");
            if(usuario != null && usuario != ""){
                
            
        %>
        <a href="EstudianteControlador?accion=cerrarsesion">Cerrar Sesion (<%= nombreUsuario%>)</a>
        <% } %>
    </div>
  </div>
</nav>