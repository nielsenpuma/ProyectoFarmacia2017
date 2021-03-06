package controlador;
import java.util.ArrayList;
import entidades.ECliente;
import modelo.MCliente;

public class CCliente {
	//Atributos
	private MCliente ObjP;
	//Constructor
	public CCliente(){
		ObjP=new MCliente();
	}
	//Metodos  a exponer
	//Listar
	public ArrayList<ECliente> Listar(){
		return ObjP.ListarCliente();
	}
	//Buscar
	public ECliente BuscarCliente(String Id){
		return ObjP.BuscarCliente(Id);
	}
	//Insertar
	public void InsertarCliente(ECliente objP){
		ObjP.InsertarCliente(objP);
	}
	//Modificar
	public void ModificarCliente(ECliente objP){
		ObjP.ModificarCliente(objP);
	}
	//Eliminar
	public void EliminarCliente(String Id){
		ObjP.EliminarCliente(Id);
	}
	
}
