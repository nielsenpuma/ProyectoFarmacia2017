package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.EProveedor;

public class MProveedor {
	//Campos o atributos
	private MConexion mysql = new MConexion();
	private Connection cn = mysql.Conectar(); //Almacenando la conexión
	
	private Statement Cmd;
	private CallableStatement Stm;
	private ResultSet Rs;
	private ArrayList<EProveedor> Lista;
	
	//Constructor
	public MProveedor() {
	}
	
	//Métodos
	//Método Listar Proveedores
	public ArrayList<EProveedor> ListarProveedor(){
		Lista = new ArrayList<>();
		String SQL = "call ListarProveedor()";
		try {
			Stm = cn.prepareCall(SQL);
			Rs = Stm.executeQuery();
			
			while(Rs.next()){
				EProveedor ObjP = new EProveedor(
						Rs.getString("COD_PRV"),
						Rs.getString("RAZ_SOC_PRV"),
						Rs.getString("DIR_PRV"),
						Rs.getString("TLF")
						);
				Lista.add(ObjP);
			}
		} catch (Exception e) {
			System.out.println("Error al listar Proveedor.\n"+e.getMessage());
		}
		return Lista;
	}
	
	//Método para cerrar la conexión al Base de Datos
	private void CerrarRecursos(){
		try {
			//Cerrar el ResultSet
			if(Rs != null)
				Rs.close();
			if(Stm != null)
				Stm.close();
			if(cn != null)
				cn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
