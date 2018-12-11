package logicGame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMain {
	
	public ArrayList<Lista> listGlobal = new ArrayList();
	private int index = 0;
	
	public void ServerMain () {}
	
	public void listening () {
		
		while(true) {
		
			 try {
		            ServerSocket server = new ServerSocket(3322);                       
		            System.out.println("Servidor iniciado na porta 3322");
		             
		            Socket cliente = server.accept();
		            System.out.println("Cliente conectado do IP "+cliente.getInetAddress().
		                    getHostAddress());
		            Scanner entrada = new Scanner(cliente.getInputStream());
		            while(entrada.hasNextLine()){
		                System.out.println(entrada.nextLine());
		            }
		             
		            entrada.close();
		            server.close();
		             
		        } catch (IOException ex) {
		        	
		            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
		        }	
			
			
		}		
	}
	
	
	public void readMessage (Message msg) {
		
		String idOperation = msg.getIdOperation(), idClient = msg.getIdClient();
		
		if (idOperation.equals("030")) {
		
			this.createThreadServer(msg, listGlobal);
					
			// envia mensagem de volta para o cliente
			
			Message message = new Message();
			message.setIdOperation("001");
			message.setIdClient(msg.getIdClient());
			message.sendToClient(); // como?			
			
		} else if (idOperation.equals("042")) { // destroi thread server
			
			int idThread = Integer.parseInt(msg.getIdServer());
			this.destroyThreadServer(msg);
			
			
		} else {
			
			System.out.println("operação invalida!");
			
		}		
	}
	
	public void createThreadServer (Message msg, ArrayList<Lista> listGlobal) {
		
		// cria thread servidora		
		ServerClient serverClient = new ServerClient(msg.getIdClient(),listGlobal);
		Lista lista = new Lista();
		lista.setIdClient(msg.getIdClient());
		lista.setIdGame("000");;
		this.listGlobal.add(lista);
		lista.setIdServer(String.valueOf(this.listGlobal.indexOf(lista)));
				
	}
	
	public void destroyThreadServer (Message msg) {
		
		this.listGlobal.remove(Integer.parseInt(msg.getIdServer()));
		// retira da lista o serverClient e seus dados
				
	}

	public ArrayList<Lista> getListGlobal() {
		return listGlobal;
	}

	public void setListGlobal(ArrayList<Lista> listGlobal) {
		this.listGlobal = listGlobal;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}