package controlador;

import java.util.ArrayList;

import entidades.ELaboratorio;
import modelo.MLaboratorio;

public class CLaboratorio {
	//atributo
	private MLaboratorio objL;
	//Metodo constructor
	public CLaboratorio(){
		objL=new MLaboratorio();
	}
	//Metodos a Exponer
	public ArrayList<ELaboratorio>Listar(){
		return objL.ListarLaboratorio();
	}

}
