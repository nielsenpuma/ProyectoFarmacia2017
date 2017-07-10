package controlador;

import java.util.ArrayList;

import entidades.EProveedor;
import modelo.MProveedor;

public class CProveedor {
	//campos o atributos
	private MProveedor ObjM;

	//Constructor
	public CProveedor() {
		ObjM = new MProveedor();
	}
	//Métodos a exponer
	//Método listar proveedores
	public ArrayList<EProveedor> Listar(){
		return ObjM.ListarProveedor();
	}
	
	//Método Buscar
	public EProveedor Buscar(String id){
		return ObjM.BuscarProveedor(id);
	}
	
	//Método FIltrar
	public ArrayList<EProveedor> Filtrar(String cad){
		return ObjM.FiltrarProveedor(cad);
	}
	
	//Método Insertar
	public void Insertar(EProveedor obj){
		ObjM.InsertarProveedor(obj);
	}
	
	//Método Modificar
	public void Modificar(EProveedor obj){
		ObjM.ModificarProveedor(obj);
	}
	
	//Método Eliminar
	public void Eliminar(String id){
		ObjM.EliminarProveedor(id);
	}
}
