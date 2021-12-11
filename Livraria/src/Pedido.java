public class Pedido {

	private Livro livro;
    private InfoEnvio infoEnvio;
    private Usuario usuario;
    private InfoCobranca infoCobranca;
    
    public InfoCobranca getInfoCobranca() {
		return infoCobranca;
	}

	public void setInfoCobranca(InfoCobranca infoCobranca) {
		this.infoCobranca = infoCobranca;
	}

	public boolean isFullFilled(){
        if(livro!=null && infoEnvio!=null && usuario!=null){
            return true;
        }
        return false;
    }

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public InfoEnvio getInfoEnvio() {
		return infoEnvio;
	}

	public void setInfoEnvio(InfoEnvio infoEnvio) {
		this.infoEnvio = infoEnvio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
