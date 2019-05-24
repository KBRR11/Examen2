/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.v2019.dao;

import pe.edu.upeu.v2019.entity.Producto;

/**
 *
 * @author alum.fial1
 */
public interface ProductoDao {
    Producto buscarProductoCodigo(int cod);
}
