package pe.edu.upeu.v2019.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


import pe.edu.upeu.v2019.dao.UsuarioDao;
import pe.edu.upeu.v2019.daoImp.UsuarioDaoImp;
import pe.edu.upeu.v2019.entity.Usuario;
import pe.edu.upeu.v2019.util.Conexion;

/**
 * Servlet implementation class ValidarController
 */
@WebServlet("/home")
public class ValidarController extends HttpServlet {
	private UsuarioDao ud = new UsuarioDaoImp();
    private Gson g = new Gson();
	private static final long serialVersionUID = 1L;
	public int intentos=0;
	
	
	private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mensaje= " ";
        int op = Integer.parseInt(request.getParameter("op"));
        HttpSession sesion = request.getSession();
        RequestDispatcher rd;
        ServletContext context= getServletContext();
        HashMap<String, Object> datos = new HashMap<>();
        datos = ud.validar(request.getParameter("user"), request.getParameter("pass"));
        //System.out.println("Error: "+datos.size());
        switch(op){
            case 1: 
            	if(3>intentos) {
            	System.out.println("Si FUNCIONA EL OPC 1!");
                    if(datos.size()>0){
                    	String nombre2;
                    	System.out.println("Ya ingresaste a la condicion");
                        sesion.setAttribute("iduser", datos.get("idu"));
                        sesion.setAttribute("user", datos.get("user"));
                        String nombres = datos.get("nom")+" "+datos.get("apell");
                        sesion.setAttribute("nombres", nombres);
                        sesion.setAttribute("nom", datos.get("nom"));
                        sesion.setAttribute("ape", datos.get("apell"));
                        sesion.setAttribute("rol", datos.get("rol"));
                        sesion.setAttribute("idp", datos.get("idp"));
                        System.out.println(datos);
                        rd=request.getRequestDispatcher("bienvenido");
                    	rd.forward(request, response);
                    }else{
                    	intentos++;
                    	System.out.println("prueba"+intentos);
                    	response.sendRedirect("inicio");
                    }
            	}else {
            		mensaje="Usuario Bloqueado";
            		out.print(mensaje);
            		
            		intentos=0;
            		System.out.println("Ya entro para los intentos: "+intentos);
            		response.sendRedirect("inicio");
            		boolean p=false;
            		int x=0;
            		try {
            			cx=Conexion.getConexion();
            			cst=cx.prepareCall("{call usuariobloqueado(?)}");
            			cst.setString(1, request.getParameter("user"));
            			x=cst.executeUpdate();
            		} catch (Exception e) {
            			// TODO: handle exception
            			System.out.println("Error: " +e);
            		}
            		
            		
            	}
            	break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}