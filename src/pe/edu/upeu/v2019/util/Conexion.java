/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.v2019.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alum.fial8
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/bdventas?zeroDateTimeBehavior=convertToNull";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection cx = null;
    public static Connection getConexion(){
        try {
            Class.forName(DRIVER);
            if(cx == null){
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        }
        return cx;
    }
   public static void cerrar() throws SQLException {
      if (cx != null) {
         cx.close();
      }
   } 
   public static void cerrar2() {
		try {
			if (cx != null) {
				cx.close();
			}
			cx = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
