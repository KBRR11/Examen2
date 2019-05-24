package pe.edu.upeu.v2019.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.edu.upeu.v2019.dao.DetalleDao;
import pe.edu.upeu.v2019.dao.PersonaDao;
import pe.edu.upeu.v2019.dao.ProductoDao;
import pe.edu.upeu.v2019.dao.VentasDao;
import pe.edu.upeu.v2019.daoImp.DetalleDaoImp;
import pe.edu.upeu.v2019.daoImp.PersonalDaoImp;
import pe.edu.upeu.v2019.daoImp.ProductoDaoImp;
import pe.edu.upeu.v2019.daoImp.VentaslDaoImp;
import pe.edu.upeu.v2019.entity.Detalle;
import pe.edu.upeu.v2019.entity.Producto;
import pe.edu.upeu.v2019.entity.Ventas;

/**
 * Servlet implementation class CarController
 */
@WebServlet("/ventas")
public class CarController extends HttpServlet {
	 private Gson g = new Gson();
	 private PersonaDao perd = new PersonalDaoImp();
	 private ProductoDao prod = new ProductoDaoImp();
	 private VentasDao vdd = new VentaslDaoImp(); 
	 private DetalleDao dd = new DetalleDaoImp();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion= request.getSession();
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        int op = Integer.parseInt(request.getParameter("opc"));
        if(sesion.getAttribute("iduser")!=null){
        switch(op){
            case 1://System.out.println(sesion.getAttribute("idp")); 
                  Producto p = prod.buscarProductoCodigo(Integer.parseInt(request.getParameter("cod")));
                  if(p.getNomprod()!=null){
                     out.println(g.toJson(prod.buscarProductoCodigo(Integer.parseInt(request.getParameter("cod")))));
                   }else{
                     out.println(0);
                   }                    
                    break;
            case 2:if (!perd.readAll(request.getParameter("dni")).isEmpty()) {
                    out.println(g.toJson(perd.readAll(request.getParameter("dni"))));
                   } else {
                    out.println(0);
                   }
                   break;
            case 3:String x = (String)sesion.getAttribute("idp"); int idv = 0;
                   idv = vdd.create(new Ventas(Integer.parseInt(x), Integer.parseInt(request.getParameter("idc"))));
                   if(idv>0){
                       out.println(idv);                       
                   }else{
                       out.println(0);
                   }
                   break;
            case 4:String dat = request.getParameter("carrito");
                   int r = 0;
                   //System.out.println(request.getParameter("id"));
                  // System.out.println(request.getParameter("id"));
                   int iddv = Integer.parseInt(request.getParameter("id"));
                   JsonParser parser = new JsonParser();
                   JsonArray gsonArr = parser.parse(dat).getAsJsonArray();
                   for (JsonElement obj : gsonArr) {
                       JsonObject gsonObj = obj.getAsJsonObject();
                       //idventas, idproducto,precio,cantidad
                       Detalle d = new Detalle(iddv, Integer.parseInt(gsonObj.get("idp").getAsString()), Double.parseDouble(gsonObj.get("pre").getAsString()), Integer.parseInt(gsonObj.get("cant").getAsString()));
                        r= dd.create(d);
                    
                   }
                   out.println(r);
                   break;            
        }
        }else{
             rd= request.getRequestDispatcher("home");
             rd.forward(request, response);           
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
