package modeloDAO;

import config.Conexion;
import interfaces.IUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;


public class UsuarioDAO implements IUsuarioDAO{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public Usuario Listar(String usuario, String contrasena) {
        Usuario user=new Usuario();
        String sql = "SELECT * FROM usuario WHERE usuario='"+usuario+"' AND contrasena='"+ contrasena + "'";
        try {            
            con = cn.ObtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contrasena"));
                user.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return user;
    }
    
}
