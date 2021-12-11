public class Livro {

	private String titulo;
	Autor autor;
	Publicadora publicadora;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Publicadora getPublicadora() {
		return publicadora;
	}

	public void setPublicadora(Publicadora publicadora) {
		this.publicadora = publicadora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
