/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.v2019.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.v2019.entity.Persona;
import pe.edu.upeu.v2019.entity.Usuario;

/**
 *
 * @author alum.fial1
 */
public interface UsuarioDao {
    HashMap<String,Object> validar(String x, String y);
    int create(Usuario u);
    int update(Usuario u);
    Persona buscador_nom(String a);
    Usuario read(int key);
    boolean search(String user);
    int bloquear_user(Usuario user2);
    List<Map<String, Object>> readAll();
}
