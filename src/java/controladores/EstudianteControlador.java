package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeloDAO.EstudianteDAO;
import modeloDAO.UsuarioDAO;
import modelos.Estudiante;
import modelos.Usuario;

public class EstudianteControlador extends HttpServlet {
    
    String listar="vistas/listar.jsp";
    String editar="vistas/editar.jsp";
    String agregar="vistas/agregar.jsp";
    String login="vistas/login.jsp";
    String inicio="index.jsp";
    Estudiante est=new Estudiante();
    EstudianteDAO dao=new EstudianteDAO();
    int idEstudiante;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudianteControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EstudianteControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acceso = "";
            String action = request.getParameter("accion");
            action = action.toLowerCase();
            
            HttpSession sesion = request.getSession();
            String usuario = (String)sesion.getAttribute("usuario");
            request.setAttribute("error", "");
            if(usuario == null || usuario.equals("")){
                if(action.equals("login")){
                   if(validarUsuario(request)){
                    acceso=inicio;
                   } else {
                      request.setAttribute("error", "Usuario o Contraseña Incorrecta");
                      acceso=login;
                   }  
                } else {
                  acceso=login;
                }                                                            
            } else {                  
                switch(action){
                    case "cerrarsesion":
                        sesion.setAttribute("usuario", "");
                        sesion.setAttribute("nombre", "");
                        acceso=login;
                        break;
                    case "listar":
                        acceso=listar;
                        break;
                    case "agregar":
                        acceso=agregar;
                        break;
                    case "guardar":
                        guardar(request);
                        acceso=listar;
                        break;
                    case "eliminar":
                        eliminar(request);
                        acceso=listar;
                        break;
                    case "editar":
                        request.setAttribute("idEstudiante", request.getParameter("idEstudiante"));
                        acceso=editar;
                        break;
                    case "actualizar":
                        actualizar(request);
                        acceso=listar;
                        break;

                }
            }
            RequestDispatcher vista=request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EstudianteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Boolean validarUsuario(HttpServletRequest request){
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.Listar(usuario, contrasena);
        if(user != null && user.getUsuario() != null ){
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", user.getUsuario());
            sesion.setAttribute("nombre", user.getNombre());
            return true;
        }        
        return false;
    }
    
    private void guardar(HttpServletRequest request) throws ParseException{
        est.setNombre(request.getParameter("nombre"));
        est.setApellido1(request.getParameter("apellido1"));
        est.setApellido2(request.getParameter("apellido2"));
        est.setCedula(request.getParameter("cedula"));
        est.setCarnet(request.getParameter("carnet"));        
        est.setFechaNac(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNac")));
        
        dao.Agregar(est);
    }
    
    private void eliminar(HttpServletRequest request){
        idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        dao.Borrar(idEstudiante);
    }
    
    private void actualizar(HttpServletRequest request) throws ParseException{
        est.setIdEstudiante(Integer.parseInt(request.getParameter("idEstudiante")));
        est.setNombre(request.getParameter("nombre"));
        est.setApellido1(request.getParameter("apellido1"));
        est.setApellido2(request.getParameter("apellido2"));
        est.setCedula(request.getParameter("cedula"));
        est.setCarnet(request.getParameter("carnet"));        
        est.setFechaNac(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNac")));
        dao.Editar(est);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
