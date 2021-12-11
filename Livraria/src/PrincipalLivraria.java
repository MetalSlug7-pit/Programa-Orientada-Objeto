import java.util.Scanner;

public class PrincipalLivraria {

	public static void main (String[] args) {
		Livro livro1=new Livro();
		livro1.setTitulo("O pequeno príncipe");
	       
	       Autor autor1=new Autor();
	       autor1.setNome("Antoine de Saint-Exupéry");
	       livro1.setAutor(autor1);
	       
	       Publicadora publicadora1=new Publicadora();
	       publicadora1.setNome("Aster");
	       livro1.setPublicadora(publicadora1);
	       
	       Usuario usuario1=new Usuario();
	       usuario1.setNome("Pedro");
	       Usuario editorial=new Editorial();
	       Usuario cliente=new Cliente();
	       
	       Remetente remetente1 = new Remetente();
	       InfoEnvio infoEnvio = new InfoEnvio();
	       infoEnvio.setRemetente(remetente1);
	       
	       Conta conta1 = new Conta();
	       usuario1.setConta(conta1);
	       conta1.setId(1);
	       conta1.setSenha("40028922");
	       conta1.setEnderecoEmail("Pedro@yahoo.com");
	       
	       InfoCobranca infoCobranca1 = new InfoCobranca();
	       infoCobranca1.setConta(conta1);
	       
	       Pedido pedido1=new Pedido();
	       pedido1.setUsuario(usuario1);
	       pedido1.setLivro(livro1);
	       pedido1.setInfoEnvio(infoEnvio);
	       pedido1.setInfoCobranca(infoCobranca1);
	       
	       if(pedido1.isFullFilled()){
	    	   Scanner scanner;
	           long id = 0;
	           String senha="";
	           try{
	               scanner= new Scanner(System.in);
	               System.out.println("Coloque seu ID:");
	               id=scanner.nextLong();
	               
	               System.out.println("Coloque sua senha:");
	               senha=scanner.next();
	           }catch(Exception e){
	               e.printStackTrace();
	           }
	           if(pedido1.getInfoCobranca().getConta().validarLogin(id, senha)){
	               System.out.println("Compra realizada");
	           }
	           else{
	               System.out.println("Informações incorretas");
	           }
	       }
	}
}
