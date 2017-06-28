package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.ELaboratorio;
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
			String SQL ="CALL ListarLabotarotorio()";
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
