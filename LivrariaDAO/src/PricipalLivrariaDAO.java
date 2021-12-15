import java.sql.SQLException;
import java.util.Scanner;

public class PricipalLivrariaDAO {

	public static void main (String[] args) throws SQLException {
		Conta conta1=new Conta();
		Livro livro1=new Livro();
		Pedido pedido1=new Pedido();
		ContaDAO contadao1=new ContaDAO();
		LivroDAO livrodao1=new LivroDAO();
		PedidoDAO pedidodao1=new PedidoDAO();
		
		conta1.setId("1");
		conta1.setSenha("1234");
		contadao1.insert(conta1);
		
		livro1.setTitulo("O livro em branco");
		livro1.setAutor("Branco");
		livro1.setPublicadora("Aster");
		livrodao1.insert(livro1);
		
		pedido1.setEndereco("Rua dos papagaios, 666");
		pedido1.setUsuario("João");
		pedidodao1.insert(pedido1);
		
		System.out.println(" ");
		System.out.println("Tabela conta: ");
		contadao1.listar(conta1);
		
		System.out.println(" ");
		System.out.println("Tabela livro: ");
		livrodao1.listar(livro1);
		
		System.out.println(" ");
		System.out.println("Tabela pedido: ");
		pedidodao1.listar(pedido1);
		
		//UPDATE
		//contadao1.update(conta1);//Alterar Email
		//livrodao1.update(livro1);//Alterar Autor
		//pedidodao1.update(pedido1);//Alterar Username
		
		//DELETE
		//contadao1.delete(conta1);
		//livrodao1.delete(livro1);
		//pedidodao1.delete(pedido1);
		
		Scanner scanner;
		String username = "";
		String senha = "";
		
		try{
            scanner= new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Coloque seu ID:");
            username=scanner.next();
            
            System.out.println("Coloque sua senha:");
            senha=scanner.next();
        }catch(Exception e){
        	e.printStackTrace();
        }
		if(username == conta1.getId() && senha == conta1.getSenha()) {
			System.out.println("Logado");
		}
		else {
			System.out.println("Informações incorretas");
		}
		System.out.println(" ");
		System.out.println("Bem vindo " + pedido1.getUsuario());
		System.out.println(" ");
		System.out.println("Sua compra: " + "\nTitulo- " + livro1.getTitulo() + "\nAutor- " + livro1.getAutor() + "\nPublicadora- " + livro1.getPublicadora());
		System.out.println(" ");
		System.out.println("Sua compra foi enviada para o endereço " + pedido1.getEndereco());
	}
}
