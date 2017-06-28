package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.EProducto;

public class MProducto {
	//campos o atributos
	private MConexion mysql = new MConexion();
	private Connection cn = mysql.Conectar(); 
	private Statement Cmd;
	private CallableStatement Stm;
	private ResultSet Rs;
	private ArrayList<EProducto> Lista;
	//constructor
	public MProducto(){}
	//Metodo Listar
	public ArrayList<EProducto>ListarProducto(){
		Lista=new ArrayList<>();
		String SQL ="CALL ListarProducto()";
		try {
			Stm = cn.prepareCall(SQL);
			Rs=Stm.executeQuery();
			while (Rs.next()) {
				EProducto objC = new EProducto(
						Rs.getString("COD_PRO"),
						Rs.getString("DESC_PRO"),
						Rs.getDouble("PRE_PRO"),
						Rs.getInt("STK_ACT"),
						Rs.getInt("STK_MIN"),
						Rs.getString("UNI_MED"),
						Rs.getString("FEC_VENC"),
						Rs.getInt("COD_LAB"),
						Rs.getInt("COD_CAT")
						);
				Lista.add(objC);
			}
		} catch (Exception e) {
			System.out.println("Error al listar Laboratorio.\n"+e.getMessage());
		}
		return Lista;
	}
	// Método para buscar
			public EProducto BuscarProducto(String Id){
				EProducto Obj =null;
				Obj = null;
				String SQL = "CALL BuscarProducto(?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setString(1, Id);
						Rs = Stm.executeQuery();
						if(Rs.next()){
							Obj = new EProducto(
									Rs.getString("COD_PRO"),
									Rs.getString("DESC_PRO"),
									Rs.getDouble("PRE_PRO"),
									Rs.getInt("STK_ACT"),
									Rs.getInt("STK_MIN"),
									Rs.getString("UNI_MED"),
									Rs.getString("FEC_VENC"),
									Rs.getInt("COD_LAB"),
									Rs.getInt("COD_CAT")
								);
						}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return Obj;
			}
			// Método para modificar
			public void ModificarProducto(EProducto ObjP){
				String SQL = "CALL ModificarProducto(?,?,?,?,?,?,?,?,?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setString(1, ObjP.getCod_pro());
						Stm.setString(2, ObjP.getDesc_pro());
						Stm.setDouble(3, ObjP.getPre_pro());
						Stm.setInt(4, ObjP.getStk_act());
						Stm.setInt(5, ObjP.getStk_min());
						Stm.setString(6, ObjP.getUnid_med());
						Stm.setString(7, ObjP.getFec_ven());
						Stm.setInt(8, ObjP.getCod_lab());
						Stm.setInt(9, ObjP.getCod_cat());
						Stm.executeUpdate();
				} catch (Exception e) {
						System.out.println(e.getMessage());
				}
			}
			// Método para insertar
			public void InsertarProducto(EProducto ObjP){
				String SQL = "CALL InsertarProducto(?,?,?,?,?,?,?,?,?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setString(1, ObjP.getCod_pro());
						Stm.setString(2, ObjP.getDesc_pro());
						Stm.setDouble(3, ObjP.getPre_pro());
						Stm.setInt(4, ObjP.getStk_act());
						Stm.setInt(5, ObjP.getStk_min());
						Stm.setString(6, ObjP.getUnid_med());
						Stm.setString(7, ObjP.getFec_ven());
						Stm.setInt(8, ObjP.getCod_lab());
						Stm.setInt(9, ObjP.getCod_cat());			
						Stm.executeUpdate();
				} catch (Exception e) {
						System.out.println(e.getMessage());
				}
			}
			// Método para eliminar
			public void EliminarProducto(String Id){
				String SQL = "CALL EliminarProducto(?)";
				try {
						Stm = cn.prepareCall(SQL);
						Stm.setString(1, Id);
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
