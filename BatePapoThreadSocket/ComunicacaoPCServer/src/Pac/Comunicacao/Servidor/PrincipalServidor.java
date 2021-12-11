/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pac.Comunicacao.Servidor;
import java.util.Scanner;

/**
 *
 * @author felip
 */
public class PrincipalServidor {
    public static void main(String[] args) {
    	Scanner mensagem1 = new Scanner(System.in);
    	Scanner mensagem2 = new Scanner(System.in);
    	String message = "";
    	String nome = "";
        
        ServidorProdutor servidorProdutor = null;
        ServidorConsumidor servidorConsumidor;
        
        MensagemBuffer mensagensServidorEnvio=new MensagemBuffer(10);
        MensagemBuffer mensagensServidorRecepcao=new MensagemBuffer(10);
        ServidorSocket servidorSocket=new ServidorSocket(8889);
        servidorSocket.conect();
        
        if (servidorSocket.getSocket() != null) {
            servidorProdutor = new ServidorProdutor(mensagensServidorEnvio, servidorSocket.getSocket());
            servidorConsumidor = new ServidorConsumidor(mensagensServidorRecepcao, servidorSocket.getSocket());
        }
        
        while (true) {
        	System.out.println(mensagensServidorRecepcao.get());
        	
        	System.out.println("Qual é o seu nome?: ");
            nome = mensagem1.nextLine();
            
            System.out.println("Ola " + nome + ", escreva sua mensagem:");
            message = mensagem2.nextLine();
            
            servidorProdutor.enviarMensagem(nome + ": " + message);
        }
          
    }
}
