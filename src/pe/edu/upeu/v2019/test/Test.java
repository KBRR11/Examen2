/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.v2019.test;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.v2019.dao.PersonaDao;
import pe.edu.upeu.v2019.dao.ProductoDao;
import pe.edu.upeu.v2019.dao.RolDao;
import pe.edu.upeu.v2019.dao.UsuarioDao;
import pe.edu.upeu.v2019.dao.VentasDao;
import pe.edu.upeu.v2019.daoImp.PersonalDaoImp;
import pe.edu.upeu.v2019.daoImp.ProductoDaoImp;
import pe.edu.upeu.v2019.daoImp.RolDaoImp;
import pe.edu.upeu.v2019.daoImp.UsuarioDaoImp;
import pe.edu.upeu.v2019.daoImp.VentaslDaoImp;
import pe.edu.upeu.v2019.entity.Persona;
import pe.edu.upeu.v2019.entity.Rol;
import pe.edu.upeu.v2019.entity.Ventas;

/**
 *
 * @author alum.fial1
 */
public class Test {
static Gson g = new Gson();
static RolDao rd = new RolDaoImp();
static UsuarioDao ud = new UsuarioDaoImp();
static ProductoDao pd = new ProductoDaoImp();
static VentasDao vd = new VentaslDaoImp();
static PersonaDao dd = new PersonalDaoImp();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        listar();
        //crear();
        per();
        //prod();
        //isertV();
    }
    static void listar(){
        System.out.println(g.toJson(rd.readAll()));
    }
    static void crear(){
        Rol x = new Rol("Gerente de Servicios");
      if(rd.create(x)>0){
          System.out.println("si");
      }else{
          System.out.println("no");
      }
    }
    static void id(){
        System.out.println(g.toJson(rd.read(4)));
    }
    static void user(){
     HashMap<String, Object> data = new HashMap<>();
     data = ud.validar("emilyc", "123");
     System.out.println(data);
        System.out.println(data.size());   
     /*
     Iterator it = data.entrySet().iterator();
     while (it.hasNext()) {
        Map.Entry e = (Map.Entry)it.next();
         System.out.println(e.getKey() + "=" + e.getValue());
     }*/
    }
    static void prod(){
        System.out.println(g.toJson(pd.buscarProductoCodigo(101)));
    }
    static void isertV(){
        Ventas v = new Ventas(2, 5);
        System.out.println(vd.create(v));
    }
    static void per(){
        
        System.out.println(g.toJson(dd.readAll("47474747")));
    }
}
