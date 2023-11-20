package interfaces;

import java.util.List;
import modelos.Estudiante;

public interface IEstudianteDAO {
    public List Listar();
    public Estudiante Listar(int idEstudiante);
    public boolean Agregar(Estudiante est);
    public boolean Editar(Estudiante est);
    public boolean Borrar(int idEstudiante);
}
