import java.util.ArrayList;
import java.util.List;

public class CadastraPessoa {

	List<Pessoa> pessoas=new ArrayList<>();

	public void addPessoa(Pessoa p) {
		pessoas.add(p);
	}
	
	public void imprimirPessoas() {
		for(int i = 0; i < pessoas.size(); i++) {
			System.out.println(pessoas.get(i).getNome() + "\n");
		}
	}
}
