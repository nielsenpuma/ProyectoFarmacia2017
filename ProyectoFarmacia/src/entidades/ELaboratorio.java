package entidades;

public class ELaboratorio {
	//campos o taributos
	private int cod_lab;
	private String desc_lab;
	//constructor
	public ELaboratorio(){}
	public ELaboratorio(int cod_lab, String desc_lab) {
		this.cod_lab = cod_lab;
		this.desc_lab = desc_lab;
	}
	//Metodos de lectura y escritura
	public int getCod_lab() {
		return cod_lab;
	}
	public void setCod_lab(int cod_lab) {
		this.cod_lab = cod_lab;
	}
	public String getDesc_lab() {
		return desc_lab;
	}
	public void setDesc_lab(String desc_lab) {
		this.desc_lab = desc_lab;
	}

}
