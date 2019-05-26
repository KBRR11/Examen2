/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.v2019.daoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.v2019.dao.UsuarioDao;
import pe.edu.upeu.v2019.entity.Persona;
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

    public Persona buscador_nom(String a) {
    	Persona p = new Persona();
    	try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call buscarid(?)}");
            cst.setString(1, a);
            rs = cst.executeQuery();
            while(rs.next()){
               p.setDni(rs.getString("dni"));
               p.setIdpersona(rs.getInt("idpersona"));
            }
        } catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " +e);
		}
        return p;
    }

    @Override
    public Usuario read(int key) {
    	Usuario u2=new Usuario();
    	try {
			cx=Conexion.getConexion();
			cst=cx.prepareCall("{call listarUsuario(?,?) }");
			cst.setInt(1,key);
			rs=cst.executeQuery();
			while (rs.next()) {
				u2.setIdpersona(rs.getInt("idpersona"));
				u2.setNom_user(rs.getString("nom_user"));
				u2.setClave(rs.getString("clave"));
				u2.setIdusuario(rs.getString("idusuario"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return u2;
    }

    @Override
    public boolean search(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Map<String, Object>> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public int bloquear_user(Usuario user2) {
		boolean p=false;
		int x=0;
		try {
			cx=Conexion.getConexion();
			cst=cx.prepareCall("{call usuariobloqueado(?)}");
			cst.setString(1, user2.getNom_user());
			x=cst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " +e);
		}
		return x;
	}
    
}
