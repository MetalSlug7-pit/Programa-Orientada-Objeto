/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pac.Comunicacao.Cliente;
import java.util.Scanner;

/**
 *
 * @author felip
 */
public class PrincipalCliente {

    public static void main(String[] args) {
    	Scanner mensagem1 = new Scanner(System.in);
    	Scanner mensagem2 = new Scanner(System.in);
    	String message = "";
    	String nome = "";
    	
        ClienteProdutor clienteProdutor = null;
        ClienteConsumidor clienteConsumidor;

        MensagemBuffer mensagensClienteEnvio = new MensagemBuffer(10);
        MensagemBuffer mensagensClienteRecepcao = new MensagemBuffer(10);
        ClienteSocket clienteSocket = new ClienteSocket("127.0.0.1", 8889);

        clienteSocket.conect();

        if (clienteSocket.getSocket() != null) {
            clienteConsumidor = new ClienteConsumidor(mensagensClienteRecepcao, clienteSocket.getSocket());
            clienteProdutor = new ClienteProdutor(mensagensClienteEnvio, clienteSocket.getSocket());

        }
        while (true) {
        	System.out.println("Qual é o seu nome?: ");
            nome = mensagem1.nextLine();
            
            System.out.println("Ola " + nome + ", escreva sua mensagem:");
            message = mensagem2.nextLine();
            
            clienteProdutor.enviarMensagem(nome + ": " + message);
            System.out.println("Servidor: " + mensagensClienteRecepcao.get());
        }
    }
}
