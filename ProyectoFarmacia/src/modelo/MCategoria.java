package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.ECategoria;


public class MCategoria {
	//campos o atributos
	private MConexion mysql = new MConexion();
	private Connection cn = mysql.Conectar(); 
	
	private Statement Cmd;
	private CallableStatement Stm;
	private ResultSet Rs;
	private ArrayList<ECategoria> Lista;
	//construtor
	public MCategoria(){}
	//Metodo ListarCategoria
	public ArrayList<ECategoria>ListarCategoria(){
		Lista=new ArrayList<>();
		String SQL ="CALL ListarCategoria()";
		try {
			Stm = cn.prepareCall(SQL);
			Rs=Stm.executeQuery();
			while (Rs.next()) {
				ECategoria objC = new ECategoria(
						Rs.getInt("COD_CAT"),
						Rs.getString("DESC_CAT")
						);
				Lista.add(objC);
			}
		} catch (Exception e) {
			System.out.println("Error al listar Laboratorio.\n"+e.getMessage());
		}
		return Lista;
	}
	// Método para buscar
		public ECategoria BuscarCategoria(int Id){
			ECategoria Obj = null;
			String SQL = "CALL BuscarCategoria(?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setInt(1, Id);
					Rs = Stm.executeQuery();
					if(Rs.next()){
						Obj = new ECategoria(
								Rs.getInt("COD_CAT"),
								Rs.getString("DESC_CAT")
							);
					}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return Obj;
		}
		// Método para modificar
		public void ModificarCategoria(ECategoria ObjC){
			String SQL = "CALL ModificarCategoria(?,?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setInt(1, ObjC.getCod_cat());
					Stm.setString(2, ObjC.getDesc_cat());
					Stm.executeUpdate();
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
		}
		// Método para insertar
		public void InsertarCategoria(ECategoria ObjC){
			String SQL = "CALL InsertarCategoria(?,?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setInt(1, ObjC.getCod_cat());
					Stm.setString(2, ObjC.getDesc_cat());			
					Stm.executeUpdate();
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
		}
		// Método para eliminar
		public void EliminarCategoria(int Id){
			String SQL = "CALL EliminaCategoria(?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setInt(1, Id);
					Stm.executeUpdate();
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
		}
		//cerrar los recursos de conexion
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
