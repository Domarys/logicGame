/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Mensagem;
import util.Status;

/**
 *
 * @author elder
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            /*
             1. Estabelecer conexão com o servidor
             2. Trocar mensagens com o servidor
             */
            //cria a conexão entre o cliente e o servvidor
            System.out.println("Estabelecendo conexão...");
            try (Socket socket = new Socket("192.168.90.34", 5555)) {
                System.out.println("Conexão estabelecida.");
                
                //criação dos streams de entrada e saída
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                System.out.println("Enviando mensagem...");
                
                Mensagem m = new Mensagem("LOGIN");
                m.setParam("user", "ALUNO");
                m.setParam("pass", "ESTUDIOSO");
                
                output.writeObject(m);
                output.flush();
                
                m = (Mensagem) input.readObject();
                System.out.println("Resposta: " + m);
                boolean sair = false;
                while (!sair) {
                    m = new Mensagem("DIV");
                    
                    m.setParam("op1", 2);
                    m.setParam("op2", 0);
                    
                    output.writeObject(m);
                    output.flush(); //libera buffer para envio
                    
                    System.out.println("Mensagem " + m + " enviada.");
                    
                    m = (Mensagem) input.readObject();
                    System.out.println("Resposta: " + m);
                    
                }
                
                input.close();
                output.close();
            }

        } catch (IOException ex) {
            System.out.println("Erro no cliente: " + ex);
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no cast: " + ex.getMessage());
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
