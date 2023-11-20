package modeloDAO;

import config.Conexion;
import interfaces.IEstudianteDAO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Estudiante;

public class EstudianteDAO implements IEstudianteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Estudiante est = new Estudiante();
    
    @Override
    public List Listar() {
        ArrayList<Estudiante> lista=new ArrayList<>();
        String sql = "SELECT * FROM estudiante";
        try {            
            con = cn.ObtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Estudiante estu=new Estudiante();
                estu.setIdEstudiante(rs.getInt("idEstudiante"));
                estu.setNombre(rs.getString("nombre"));
                estu.setApellido1(rs.getString("apellido1"));
                estu.setApellido2(rs.getString("apellido2"));
                estu.setCedula(rs.getString("cedula"));
                estu.setCarnet(rs.getString("carnet"));
                estu.setFechaNac(rs.getDate("fechaNac"));
                lista.add(estu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    @Override
    public Estudiante Listar(int idEstudiante) {
        Estudiante est=new Estudiante();
        String sql = "SELECT * FROM estudiante WHERE idEstudiante="+idEstudiante;
        try {            
            con = cn.ObtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                est.setIdEstudiante(rs.getInt("idEstudiante"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido1(rs.getString("apellido1"));
                est.setApellido2(rs.getString("apellido2"));
                est.setCedula(rs.getString("cedula"));
                est.setCarnet(rs.getString("carnet"));
                est.setFechaNac(rs.getDate("fechaNac"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return est;
    }

    @Override
    public boolean Agregar(Estudiante est) {
        try {
            String fechaNac = "";
            if(est.getFechaNac() != null) {
                fechaNac = new SimpleDateFormat("yyyy-MM-dd").format(est.getFechaNac());
            }   
            String sql = "INSERT INTO estudiante (nombre, apellido1, apellido2, cedula, carnet, fechaNac) " + "VALUES ('"+est.getNombre()+"', '"+est.getApellido1()+"', '"+est.getApellido2()+"', '"+ est.getCarnet() +"', '" + est.getCarnet() + "', '" + fechaNac + "')";
            
            con = cn.ObtenerConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (SQLException ex) {            
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
        return true;
    }

    @Override
    public boolean Editar(Estudiante est) {
        String fechaNac = "";
        if(est.getFechaNac() != null) {
            fechaNac = new SimpleDateFormat("yyyy-MM-dd").format(est.getFechaNac());
        }                
        String sql = "UPDATE estudiante SET nombre='"+est.getNombre()+"', apellido1='"+est.getApellido1()+"', apellido2='"+est.getApellido2()+"', cedula = '"+ est.getCedula() + "', carnet = '" + est.getCarnet() + "', fechaNac = '" + fechaNac + "' WHERE idEstudiante = " + est.getIdEstudiante();
        try {
            con = cn.ObtenerConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }

    @Override
    public boolean Borrar(int idEstudiante) {
        String sql = "DELETE FROM estudiante WHERE idEstudiante = "+idEstudiante;                 
        try {
            con = cn.ObtenerConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }
    
}
