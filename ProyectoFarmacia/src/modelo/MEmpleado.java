package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.ECliente;
import entidades.EEmpleado;
import entidades.EProveedor;
import java.text.SimpleDateFormat;

public class MEmpleado {
	//Campos o atributos
	

		private MConexion mysql = new MConexion();
		private Connection cn = mysql.Conectar(); //Almacenando la conexi�n	
		private Statement Cmd;
		private CallableStatement Stm;
		private ResultSet Rs;
		private ArrayList<EEmpleado> Lista;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		//metodo constructor
		public MEmpleado(){}
		//Metodos
		//Metodo Listar 
		public ArrayList<EEmpleado> ListarEmpleado(){
			Lista = new ArrayList<>();
			String SQL = "call ListarEmpleado()";
			try {
				Stm = cn.prepareCall(SQL);
				Rs = Stm.executeQuery();
				
				while(Rs.next()){
					EEmpleado ObjP = new EEmpleado(
							Rs.getString("COD_EMP"),
							Rs.getString("NOM_EMP"),
							Rs.getString("APAT_EMP"),
							Rs.getString("AMAT_EMP"),
							Rs.getDate("FEC_NAC_EMP"),
							Rs.getDate("FEC_ING_EMP"),
							Rs.getString("USER_EMP"),
							Rs.getString("PASS_EMP"),
							Rs.getInt("COD_CARGO")
							);
					Lista.add(ObjP);
				}
			} catch (Exception e) {
				System.out.println("Error al listar Empleado.\n"+e.getMessage());
			}
			return Lista;
		}

		// Método para buscar
		public EEmpleado BuscarEmpleado(String Id){
			EEmpleado Obj =null;
			Obj = null;
			String SQL = "CALL BuscarEmpleado(?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setString(1, Id);
					Rs = Stm.executeQuery();
					if(Rs.next()){
						Obj = new EEmpleado(
								Rs.getString("COD_EMP"),
								Rs.getString("NOM_EMP"),
								Rs.getString("APAT_EMP"),
								Rs.getString("AMAT_EMP"),
								Rs.getDate("FEC_NAC_EMP"),
								Rs.getDate("FEC_ING_EMP"),
								Rs.getString("USER_EMP"),
								Rs.getString("PASS_EMP"),
								Rs.getInt("COD_CARGO")
							);
					}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return Obj;
		}	
		
		// Método para modificar
		public void ModificarEmpleado(EEmpleado ObjP){
			String SQL = "CALL ModificarEmpleado(?,?,?,?,?,?,?,?,?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setString(1, ObjP.getCod_emp());
					Stm.setString(2, ObjP.getNom_emp());
					Stm.setString(3, ObjP.getApat_emp());
					Stm.setString(4, ObjP.getAmat_emp());
					Stm.setString(5, sdf.format(ObjP.getFec_ing_emp()));
					Stm.setString(6, sdf.format(ObjP.getFec_ing_emp()));
					Stm.setString(7, ObjP.getUser_emp());
					Stm.setString(8, ObjP.getPass_emp());
					Stm.setInt(9, ObjP.getCod_cargo());
					Stm.executeUpdate();
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
		}
		// Método para insertar
		public void InsertarEmpleado(EEmpleado ObjP){
			String SQL = "CALL InsertarEmpleado(?,?,?,?,?,?,?,?,?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setString(1, ObjP.getCod_emp());
					Stm.setString(2, ObjP.getNom_emp());
					Stm.setString(3, ObjP.getApat_emp());
					Stm.setString(4, ObjP.getAmat_emp());
					Stm.setString(5, sdf.format(ObjP.getFec_ing_emp()));
					Stm.setString(6, sdf.format(ObjP.getFec_ing_emp()));
					Stm.setString(7, ObjP.getUser_emp());
					Stm.setString(8, ObjP.getPass_emp());
					Stm.setInt(9, ObjP.getCod_cargo());	
					Stm.executeUpdate();
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
		}
		// Método para eliminar
		public void EliminarEmpleado(String Id){
			String SQL = "CALL EliminarEmpleado(?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setString(1, Id);
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
		
		//M�todo para autentificar el usuario del sistema
		public EEmpleado AutentificarUsuario(String user, String password){
			EEmpleado Obj =null;
			Obj = null;
			String SQL = "CALL AutentificarUsuario(?,?)";
			try {
					Stm = cn.prepareCall(SQL);
					Stm.setString(1, user);
					Stm.setString(2, password);
					Rs = Stm.executeQuery();
					if(Rs.next()){
						Obj = new EEmpleado(
								Rs.getString("COD_EMP"),
								Rs.getString("NOM_EMP"),
								Rs.getString("APAT_EMP"),
								Rs.getString("AMAT_EMP"),
								Rs.getDate("FEC_NAC_EMP"),
								Rs.getDate("FEC_ING_EMP"),
								Rs.getString("USER_EMP"),
								Rs.getString("PASS_EMP"),
								Rs.getInt("COD_CARGO")
							);
					}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return Obj;
		}

		


}
