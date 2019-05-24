package pe.edu.upeu.v2019.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.v2019.dao.RolDao;
import pe.edu.upeu.v2019.daoImp.RolDaoImp;
import pe.edu.upeu.v2019.entity.Rol;

/**
 * Servlet implementation class RolController
 */
@WebServlet("/rol")
public class RolController extends HttpServlet {
    private RolDao rd = new RolDaoImp();
    private Gson g = new Gson();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolController() {
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
        switch(op){
            case 1: out.println(g.toJson(rd.readAll()));
                    break;
            case 2: out.println(g.toJson(rd.read(Integer.parseInt(request.getParameter("id")))));
                    break;
            case 3: Rol rol = new Rol(request.getParameter("nombrerol")); 
                    rd.create(rol);
                    break;
            case 4: Rol ro = new Rol(Integer.parseInt(request.getParameter("id")), request.getParameter("nomrol"));
                    rd.update(ro);
                    break;
            case 5: rd.delete(Integer.parseInt(request.getParameter("id")));
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
