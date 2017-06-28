package entidades;

public class ECategoria {
	//atributos
	private int cod_cat;
	private String desc_cat;
	//constructor
	public ECategoria(){}
	public ECategoria(int cod_cat, String desc_cat) {
		this.cod_cat = cod_cat;
		this.desc_cat = desc_cat;
	}
	//Metodos de lectura y escritura
	public int getCod_cat() {
		return cod_cat;
	}
	public void setCod_cat(int cod_cat) {
		this.cod_cat = cod_cat;
	}
	public String getDesc_cat() {
		return desc_cat;
	}
	public void setDesc_cat(String desc_cat) {
		this.desc_cat = desc_cat;
	}

}
