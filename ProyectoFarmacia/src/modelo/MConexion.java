package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class MConexion {
	//Campos o atributos
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bd_farmacia"; //Conexi�n BD_Farmacia
	private String User = "root";
	private String Password = "mysql";
	//Constructor
	public MConexion() {
	}
	//Métodos
	public Connection Conectar(){
		Connection cn = null;
		try {
			Class.forName(Driver);
			cn = DriverManager.getConnection(URL,User,Password);
		} catch (Exception e) {
			System.out.println("Error al conectar BD.\n"+e.getMessage());
		}
		return cn;
	}
}
