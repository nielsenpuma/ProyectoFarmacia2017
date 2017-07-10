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
	//M�todos a exponer
	//M�todo listar proveedores
	public ArrayList<EProveedor> Listar(){
		return ObjM.ListarProveedor();
	}
	
	//M�todo Buscar
	public EProveedor Buscar(String id){
		return ObjM.BuscarProveedor(id);
	}
	
	//M�todo FIltrar
	public ArrayList<EProveedor> Filtrar(String cad){
		return ObjM.FiltrarProveedor(cad);
	}
	
	//M�todo Insertar
	public void Insertar(EProveedor obj){
		ObjM.InsertarProveedor(obj);
	}
	
	//M�todo Modificar
	public void Modificar(EProveedor obj){
		ObjM.ModificarProveedor(obj);
	}
	
	//M�todo Eliminar
	public void Eliminar(String id){
		ObjM.EliminarProveedor(id);
	}
}
