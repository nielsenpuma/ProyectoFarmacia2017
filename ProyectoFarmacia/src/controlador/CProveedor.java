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
	
}
