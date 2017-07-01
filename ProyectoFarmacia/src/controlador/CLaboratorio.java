package controlador;

import java.util.ArrayList;

import entidades.ELaboratorio;
import modelo.MLaboratorio;

public class CLaboratorio {
	//atributo
	private MLaboratorio objLab;
	//Metodo constructor
	public CLaboratorio(){
		objLab=new MLaboratorio();
	}
	//Metodos a Exponer
	//Listar
	public ArrayList<ELaboratorio>Listar(){
		return objLab.ListarLaboratorio();
	}
	//Buscar
	public ELaboratorio Buscar(int Id){
		return objLab.BuscarLaboratorio(Id);
	}
	//Insertar
	public void Insertar(ELaboratorio objL){
		objLab.InsertarLaboratorio(objL);
	}
	//Modificar
	public void Modificar(ELaboratorio objL){
		objLab.ModificarLaboratorio(objL);
	}
	//Eliminar
	public void Eliminar(int Id){
		objLab.EliminarLaboratorio(Id);
	}
}
