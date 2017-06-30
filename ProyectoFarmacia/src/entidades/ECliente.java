package entidades;

public class ECliente {
	//Atributos
	private String cod_cli;
	private String nom_cli;
	private String apat_cli;
	private String amaT_cli;
	private String fec_reg_cli;
	private String tlf_cliente;
	//Constructor
	public ECliente(String cod_cli, String nom_cli, String apat_cli, String amaT_cli, String fec_reg_cli,
			String tlf_cliente) {
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.apat_cli = apat_cli;
		this.amaT_cli = amaT_cli;
		this.fec_reg_cli = fec_reg_cli;
		this.tlf_cliente = tlf_cliente;
	}
	//Métodos Get & Set
	public String getCod_cli() {
		return cod_cli;
	}
	public void setCod_cli(String cod_cli) {
		this.cod_cli = cod_cli;
	}
	public String getNom_cli() {
		return nom_cli;
	}
	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}
	public String getApat_cli() {
		return apat_cli;
	}
	public void setApat_cli(String apat_cli) {
		this.apat_cli = apat_cli;
	}
	public String getAmaT_cli() {
		return amaT_cli;
	}
	public void setAmaT_cli(String amaT_cli) {
		this.amaT_cli = amaT_cli;
	}
	public String getFec_reg_cli() {
		return fec_reg_cli;
	}
	public void setFec_reg_cli(String fec_reg_cli) {
		this.fec_reg_cli = fec_reg_cli;
	}
	public String getTlf_cliente() {
		return tlf_cliente;
	}
	public void setTlf_cliente(String tlf_cliente) {
		this.tlf_cliente = tlf_cliente;
	}

}
