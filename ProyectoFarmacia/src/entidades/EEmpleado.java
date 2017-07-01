package entidades;

public class EEmpleado {
	//campos o atributos
	private String cod_emp;
	private String nom_emp;
	private String apat_emp;
	private String amat_emp;
	private String fec_nac_emp;
	private String fec_ing_emp;
	private String user_emp;
	private String pass_emp;
	private int cod_cargo;
	public String getCod_emp() {
		return cod_emp;
	}
	public void setCod_emp(String cod_emp) {
		this.cod_emp = cod_emp;
	}
	public String getNom_emp() {
		return nom_emp;
	}
	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}
	public String getApat_emp() {
		return apat_emp;
	}
	public void setApat_emp(String apat_emp) {
		this.apat_emp = apat_emp;
	}
	public String getAmat_emp() {
		return amat_emp;
	}
	public void setAmat_emp(String amat_emp) {
		this.amat_emp = amat_emp;
	}
	public String getFec_nac_emp() {
		return fec_nac_emp;
	}
	public void setFec_nac_emp(String fec_nac_emp) {
		this.fec_nac_emp = fec_nac_emp;
	}
	public String getFec_ing_emp() {
		return fec_ing_emp;
	}
	public void setFec_ing_emp(String fec_ing_emp) {
		this.fec_ing_emp = fec_ing_emp;
	}
	public String getUser_emp() {
		return user_emp;
	}
	public void setUser_emp(String user_emp) {
		this.user_emp = user_emp;
	}
	public String getPass_emp() {
		return pass_emp;
	}
	public void setPass_emp(String pass_emp) {
		this.pass_emp = pass_emp;
	}
	public int getCod_cargo() {
		return cod_cargo;
	}
	public void setCod_cargo(int cod_cargo) {
		this.cod_cargo = cod_cargo;
	}
	
	public EEmpleado(){}
	public EEmpleado(String cod_emp, String nom_emp, String apat_emp, String amat_emp, String fec_nac_emp,
			String fec_ing_emp, String user_emp, String pass_emp, int cod_cargo) {
		this.cod_emp = cod_emp;
		this.nom_emp = nom_emp;
		this.apat_emp = apat_emp;
		this.amat_emp = amat_emp;
		this.fec_nac_emp = fec_nac_emp;
		this.fec_ing_emp = fec_ing_emp;
		this.user_emp = user_emp;
		this.pass_emp = pass_emp;
		this.cod_cargo = cod_cargo;
	}
	
	
}
