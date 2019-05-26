/*
 * and open the template in the editor.
 */
package pe.edu.upeu.v2019.entity;

/**
 *
 * @author alum.fial1
 */
public class Usuario {
	String idusuario;
	String nom_user;
	String clave;
	String idrol;
	int idpersona;
	int  estado;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String idusuario, String nom_user, String clave, String idrol, int idpersona, int estado) {
		super();
		this.idusuario = idusuario;
		this.nom_user = nom_user;
		this.clave = clave;
		this.idrol = idrol;
		this.idpersona = idpersona;
		this.estado = estado;
	}
	
	public Usuario(String nom_user, int estado) {
		super();
		this.nom_user = nom_user;
		this.estado = estado;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getNom_user() {
		return nom_user;
	}
	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getIdrol() {
		return idrol;
	}
	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
