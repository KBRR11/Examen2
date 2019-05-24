/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.v2019.daoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.v2019.dao.UsuarioDao;
import pe.edu.upeu.v2019.entity.Usuario;
import pe.edu.upeu.v2019.util.Conexion;

/**
 *
 * @author alum.fial1
 */
public class UsuarioDaoImp implements UsuarioDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
	private PreparedStatement ps;
	
	
    @Override
    public HashMap<String, Object> validar(String x, String y) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call validarUser(?,?)}");
            cst.setString(1, x);
            cst.setString(2, y);
            rs = cst.executeQuery();
            while(rs.next()){                
                map.put("idu", rs.getInt("idusuario"));
                map.put("user", rs.getString("nom_user"));
                map.put("nom", rs.getString("nombres"));
                map.put("apell", rs.getString("apellidos"));
                map.put("rol", rs.getString("nom_rol"));
                 map.put("idp", rs.getString("idpersona"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);            
        }
        return map;
    }

    @Override
    public int create(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    public Usuario Validacion(String user, String clave) {
		Usuario u =new Usuario();
		 String sql = "select * from usuario where nom_user = ? and clave=?";
		 try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				u.setIdusuario(rs.getInt("idusuario"));
				u.setIdrol(rs.getInt("idrol"));
				u.setNom_user(rs.getString("nom_user"));
				u.setClave(rs.getString("clave"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
				Conexion.cerrar2();
			}
		 return u;
	}

    @Override
    public Usuario read(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Map<String, Object>> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
