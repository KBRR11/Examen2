package pe.edu.upeu.v2019.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.ldap.Rdn;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.v2019.dao.PersonaDao;
import pe.edu.upeu.v2019.dao.UsuarioDao;
import pe.edu.upeu.v2019.daoImp.PersonalDaoImp;
import pe.edu.upeu.v2019.daoImp.UsuarioDaoImp;
import pe.edu.upeu.v2019.util.Conexion;

/**
 * Servlet implementation class usernotventa
 */
@WebServlet("/unv")
public class usernotventa extends HttpServlet {
	UsuarioDao ud=new UsuarioDaoImp();
	PersonaDao pd=new PersonalDaoImp();
	private Gson g = new Gson();
	private static final long serialVersionUID = 1L;
	
	private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usernotventa() {
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
        int op = Integer.parseInt(request.getParameter("opc"));
        switch (op) {
		case 1:
			out.println(g.toJson(ud.buscador_nom(request.getParameter("nombre"))));
			break;
		case 2:
			int x=0;
    		try {
    			cx=Conexion.getConexion();
    			cst=cx.prepareCall("{call buscarid(?)}");
    			cst.setString(1, request.getParameter("nombre"));
    			x=cst.executeUpdate();
    		} catch (Exception e) {
    			// TODO: handle exception
    			System.out.println("Error: " +e);
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
