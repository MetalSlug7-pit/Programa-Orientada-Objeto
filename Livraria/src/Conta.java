public class Conta {

	private String enderecoEmail;
	private long id;
	private String senha;
	
	private long idTemp;
	private String senhaTemp;
	
	public boolean verificarSenha() {
		if(senha.equals(senhaTemp)) {
			return true;
		}
		return false;
	}
	
	public boolean validarLogin(long id, String senha) {
		idTemp = id;
		senhaTemp = senha;
		return (validarLogin() && verificarSenha());
	}

	public boolean validarLogin() {
		if(id==idTemp) {
			return true;
		}
		return false;
	}
	
	public String getEnderecoEmail() {
		return enderecoEmail;
	}
	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
