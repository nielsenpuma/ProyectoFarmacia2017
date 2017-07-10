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
						Rs.getString("TLF_PRV")
						);
				Lista.add(ObjP);
			}
		} catch (Exception e) {
			System.out.println("Error al listar Proveedor.\n"+e.getMessage());
		}
		return Lista;
	}
	
	//Actualizar Proveedor
	public void ModificarProveedor(EProveedor obj){
		String SQL = "CALL ModificarProveedor(?,?,?,?)";
		try {
			Stm = cn.prepareCall(SQL);
			Stm.setString(1, obj.getCod_prv());
			Stm.setString(2, obj.getRaz_soc_prv());
			Stm.setString(3, obj.getDir_prv());
			Stm.setString(4, obj.getTlf());
			Stm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar Prov.\n"+e.getMessage());
		}
	}
	//Eliminar Proveedor
	public void EliminarProveedor(String id){
		String SQL= "CALL EliminarProveedor(?)";
		try {
			Stm = cn.prepareCall(SQL);
			Stm.setString(1, id);
			Stm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar Prov.\n"+e.getMessage());
		}
	}
	//Buscar Proveedor
	public EProveedor BuscarProveedor(String id){
		EProveedor objP = null;
		String SQL = "CALL BuscarProveedor(?)";
		try {
			Stm = cn.prepareCall(SQL);
			Stm.setString(1, id);
			Rs = Stm.executeQuery();
			
			if (Rs.next()) {
				objP = new EProveedor(
						Rs.getString("COD_PRV"),
						Rs.getString("RAZ_SOC_PRV"),
						Rs.getString("DIR_PRV"),
						Rs.getString("TLF_PRV")
						);
			}
		} catch (Exception e) {
			System.out.println("Error al buscar Prov.\n"+e.getMessage());
		}
		return objP;
	}
	//Filtrar 
	public ArrayList<EProveedor> FiltrarProveedor(String cad){
		Lista = new ArrayList<>();
		String SQL = "call BuscarProveedor(?)";
		try {
			Stm = cn.prepareCall(SQL);
			Stm.setString(1, cad);
			Rs = Stm.executeQuery();
			
			while(Rs.next()){
				EProveedor ObjP = new EProveedor(
						Rs.getString("COD_PRV"),
						Rs.getString("RAZ_SOC_PRV"),
						Rs.getString("DIR_PRV"),
						Rs.getString("TLF_PRV")
						);
				Lista.add(ObjP);
			}
		} catch (Exception e) {
			System.out.println("Error al listar Proveedor.\n"+e.getMessage());
		}
		return Lista;
	}
	
	//Insertar Proveedor
	public void InsertarProveedor(EProveedor obj){
		String SQL = "CALL InsertarProveedor(?,?,?,?)";
		try {
			Stm = cn.prepareCall(SQL);
			Stm.setString(1, obj.getCod_prv());
			Stm.setString(2, obj.getRaz_soc_prv());
			Stm.setString(3, obj.getDir_prv());
			Stm.setString(4, obj.getTlf());
			
			Stm.executeQuery();
		} catch (Exception e) {
			System.out.println("Error al ingresar Prov.\n"+e.getMessage());
		}
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
