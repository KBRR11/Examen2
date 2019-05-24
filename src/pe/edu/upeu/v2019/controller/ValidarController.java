package pe.edu.upeu.v2019.controller;

import java.io.IOException;
import java.io.PrintWriter;
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


/**
 * Servlet implementation class ValidarController
 */
@WebServlet("/home")
public class ValidarController extends HttpServlet {
	private UsuarioDao ud = new UsuarioDaoImp();
    private Gson g = new Gson();
	private static final long serialVersionUID = 1L;
       
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
        int op = Integer.parseInt(request.getParameter("op"));
        HttpSession sesion = request.getSession();
        RequestDispatcher rd;
        ServletContext context= getServletContext();
        HashMap<String, Object> datos = new HashMap<>();
        datos = ud.validar(request.getParameter("user"), request.getParameter("pass"));
        //System.out.println("Error: "+datos.size());
        String x = "";
		String y = "";
        switch(op){
            case 1: 
                    if(datos.size()>0){
                        sesion.setAttribute("iduser", datos.get("idu"));
                        sesion.setAttribute("user", datos.get("user"));
                        String nombres = datos.get("nom")+" "+datos.get("apell");
                        sesion.setAttribute("nombres", nombres);
                        sesion.setAttribute("rol", datos.get("rol"));
                        sesion.setAttribute("idp", datos.get("idp"));
                        System.out.println(datos);
                        rd= request.getRequestDispatcher("bienvenido");
                        rd.forward(request, response);
                    }else{
                    	 x = request.getParameter("user");
                		 y = request.getParameter("pass");
                		 pe.edu.upeu.v2019.entity.Usuario u = new pe.edu.upeu.v2019.entity.Usuario();
                		 u.setIdusuario(0);
                		 u = ud.Validacion(x, y);
                		 
                			out.println(g.toJson(u));
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
