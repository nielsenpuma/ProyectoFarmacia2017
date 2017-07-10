package entidades;

public class EProveedor {
	//Campos o atributos
	private String cod_prv;
	private String raz_soc_prv;
	private String dir_prv;
	private String tlf;
	//Constructores
	public EProveedor() {
	}
	public EProveedor(String cod_prv, String raz_soc_prv, String dir_prv, String tlf) {
		this.cod_prv = cod_prv;
		this.raz_soc_prv = raz_soc_prv;
		this.dir_prv = dir_prv;
		this.tlf = tlf;
	}
	//Lectura y escritura
	public String getCod_prv() {
		return cod_prv;
	}
	public void setCod_prv(String cod_prv) {
		this.cod_prv = cod_prv;
	}
	public String getRaz_soc_prv() {
		return raz_soc_prv;
	}
	public void setRaz_soc_prv(String raz_soc_prv) {
		this.raz_soc_prv = raz_soc_prv;
	}
	public String getDir_prv() {
		return dir_prv;
	}
	public void setDir_prv(String dir_prv) {
		this.dir_prv = dir_prv;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	
	//Sobrescribiendo toString para que muestre resultados
	public String toString(){
		return this.raz_soc_prv;
	}
	
}
