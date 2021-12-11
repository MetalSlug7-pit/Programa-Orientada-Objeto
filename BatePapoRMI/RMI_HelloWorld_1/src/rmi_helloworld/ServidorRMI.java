/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_helloworld;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author felip
 */
public class ServidorRMI {
        public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException, InterruptedException {
        ServerMensagem msg=new ServerMensagem("");
        RMIServer sv=new RMIServer(msg);
        Scanner mensagem = new Scanner(System.in);
    	String message1 = "";
    	String message2 = "";
    	String nome = "";
        
        Thread.sleep(10000);
        
        mensagem = new Scanner(System.in);
    	System.out.println("Qual é o seu nome?: ");
        nome = mensagem.nextLine();
        
        System.out.println("Ola " + nome + ", escreva sua mensagem:");
        message1 = mensagem.nextLine();
        
        message2 = nome + ": " + message;
        sv.msgBuffer.setMsg(message2);
    }
}
