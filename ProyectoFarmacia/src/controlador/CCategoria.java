package controlador;

import java.util.ArrayList;

import entidades.ECategoria;
import modelo.MCategoria;

public class CCategoria {
	//atributo
	private MCategoria objCat;
	//constructor
	public CCategoria(){
		objCat = new MCategoria();
	}
	//metodos a exponer
	//listar
	public ArrayList<ECategoria>Listar(){
		return objCat.ListarCategoria();
	}
	//Buscar
	public ECategoria Buscar(int Id){
		return objCat.BuscarCategoria(Id);
	}
	//insertar
	public void Insertar(ECategoria objC){
		objCat.InsertarCategoria(objC);
	}
	//modificar
	public void Modificar(ECategoria objC){
		objCat.ModificarCategoria(objC);
	}
	//ELIMINAR
	public void Eliminar(int Id){
		objCat.EliminarCategoria(Id);
	}

}