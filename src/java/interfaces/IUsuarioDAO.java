/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelos.Usuario;

/**
 *
 * @author Greivin Marin
 */
public interface IUsuarioDAO {
    public Usuario Listar(String usuario, String contrasena);
}
