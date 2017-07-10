package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.ELaboratorio;
import entidades.EProducto;
public class MLaboratorio {
	//Campos o atributos
		private MConexion mysql = new MConexion();
		private Connection cn = mysql.Conectar(); 
		
		private Statement Cmd;
		private CallableStatement Stm;
		private ResultSet Rs;
		private ArrayList<ELaboratorio> Lista;
		//construtor
		public MLaboratorio(){}
		//Metodos ListarLabotario
		public ArrayList<ELaboratorio> ListarLaboratorio(){
			Lista=new ArrayList<>();
			String SQL ="CALL ListarLaboratorio()";
			try {
				Stm = cn.prepareCall(SQL);
				Rs=Stm.executeQuery();
				while (Rs.next()) {
					ELaboratorio objL = new ELaboratorio(
							Rs.getInt("COD_LAB"),
							Rs.getString("DESC_LAB")
							);
					Lista.add(objL);
				}
			} catch (Exception e) {
				System.out.println("Error al listar Laboratorio.\n"+e.getMessage());
			}
			return Lista;
		}
		// Método para buscar
			public ELaboratorio BuscarLaboratorio(int Id){
				ELaboratorio Obj =null;
				String SQL = "CALL BuscarLaboratorio(?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setInt(1, Id);
						Rs = Stm.executeQuery();
						if(Rs.next()){
							Obj = new ELaboratorio (
									Rs.getInt("COD_LAB"),
									Rs.getString("DESC_LAB")
								);
						}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return Obj;
			}
			// Método para modificar
			public void ModificarLaboratorio(ELaboratorio objL ){
				String SQL = "CALL ModificarLaboratorio(?,?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setInt(1, objL.getCod_lab());
						Stm.setString(2, objL.getDesc_lab());
						Stm.executeUpdate();
				} catch (Exception e) {
						System.out.println(e.getMessage());
				}
			}
			// Método para insertar
			public void InsertarLaboratorio(ELaboratorio objL ){
				String SQL = "CALL InsertarLaboratorio(?,?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setInt(1, objL.getCod_lab());
						Stm.setString(2, objL.getDesc_lab());
						Stm.executeUpdate();
				} catch (Exception e) {
						System.out.println(e.getMessage());
				}
			}
			// Método para eliminar
			public void EliminarLaboratorio(int Id ){
				String SQL = "CALL EliminarLaboratorio(?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setInt(1, Id);
						Stm.executeUpdate();
				} catch (Exception e) {
						System.out.println(e.getMessage());
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
