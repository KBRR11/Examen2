package pe.edu.upeu.v2019.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/menu")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
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
        System.out.println(op);
        RequestDispatcher rd;
        switch(op){
            case 1: rd= request.getRequestDispatcher("view/rol.jsp");
                    rd.forward(request, response);
                    break;
            case 2: rd= request.getRequestDispatcher("view/per.jsp");
                    rd.forward(request, response);
                    break;
            case 3: rd= request.getRequestDispatcher("view/user.jsp");
                    rd.forward(request, response);
                    break;
            case 4: rd= request.getRequestDispatcher("view/prod.jsp");
                    rd.forward(request, response);
                    break;
            case 5: rd= request.getRequestDispatcher("view/ventas.jsp");
                    rd.forward(request, response);
                    break;
            case 6: rd= request.getRequestDispatcher("view/reportes.jsp");
                    rd.forward(request, response);
                    break;
            case 7: rd= request.getRequestDispatcher("view/p.jsp");
                    rd.forward(request, response);
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
