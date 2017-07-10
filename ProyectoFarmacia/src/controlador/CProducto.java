package controlador;

import java.util.ArrayList;

import entidades.EProducto;
import modelo.MProducto;

public class CProducto {
	//atributos
	private MProducto objP;
	//constructor
	public CProducto(){
		objP=new MProducto();
	}
	//Metodos  aexponer
	//listr
	public ArrayList<EProducto> Listar(){
		return objP.ListarProducto();
	}
	//Busaccr
	public EProducto Buscar(String des){
		return objP.BuscarProducto(des);
	}
	//Insertar
	public void Insertar(EProducto ObjP){
		objP.InsertarProducto(ObjP);
	}
	//Modificar
	public void Modificar(EProducto ObjP){
		objP.ModificarProducto(ObjP);
	}
	//Eliminar
	public void Eliminar(String Id){
		objP.EliminarProducto(Id);
	}
	
}
