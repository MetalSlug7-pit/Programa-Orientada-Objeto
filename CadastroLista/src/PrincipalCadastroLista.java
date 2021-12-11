public class PrincipalCadastroLista {

	public static void main(String[] args) {
		Pessoa p1=new Pessoa();
		p1.setNome("Joao");
		p1.setEndereco("Rua A");
		p1.setTelefone("40028922");
		p1.setIdade(20);
		
		Pessoa p2=new Pessoa();
		p2.setNome("Jose");
		p2.setEndereco("Rua B");
		p2.setTelefone("22982004");
		p2.setIdade(30);
		
		Pessoa p3=new Pessoa();
		p3.setNome("Pedro");
		p3.setEndereco("Rua AH");
		p3.setTelefone("99722-2839");
		p3.setIdade(19);
		
		System.out.println("Pessoas Cadastradas:");
		imprimirPessoa(p1);
		imprimirPessoa(p2);
		imprimirPessoa(p3);
		
		System.out.println("\nEm Forma de Lista:");
		CadastraPessoa cadastro=new CadastraPessoa();
		
		cadastro.addPessoa(p1);
		cadastro.imprimirPessoas();
		
		cadastro.addPessoa(p2);
		cadastro.imprimirPessoas();
		
		cadastro.addPessoa(p3);
		cadastro.imprimirPessoas();
	}
	
	public static void imprimirPessoa(Pessoa p) {
		System.out.println(p.getNome());
	}
}
