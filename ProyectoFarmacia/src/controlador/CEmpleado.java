package controlador;

import java.util.ArrayList;

import entidades.ECliente;
import entidades.EEmpleado;
import modelo.MCliente;
import modelo.MEmpleado;

public class CEmpleado {
		
		//Atributos
		private MEmpleado ObjP;
		//Constructor
		public CEmpleado(){
			ObjP=new MEmpleado();
		}
		//Metodos  a exponer
		//Listar
		public ArrayList<EEmpleado> Listar(){
			return ObjP.ListarEmpleado();
		}
		
		//Buscar
		public EEmpleado Buscar(String Id){
			return ObjP.BuscarEmpleado(Id);
		}
		//Insertar
		public void Insertar(EEmpleado objP){
			ObjP.InsertarEmpleado(objP);
		}
		//Modificar
		public void ModificarEmpleado(EEmpleado objP){
			ObjP.ModificarEmpleado(objP);
		}
		//Eliminar
		public void EliminarEmpleado(String Id){
			ObjP.EliminarEmpleado(Id);
		}
		
		 
}
