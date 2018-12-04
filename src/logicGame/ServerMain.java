package logicGame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ServerMain {
	
	private ArrayList<String> threadServer = new ArrayList();
	private ArrayList<String> scoreThread = new ArrayList();

	
	public void ServerMain () {}
	
	public void wait_connection() {
		System.out.println("lola on");
		// ao verificar a chegada de uma msg 
		// chama o metodo readMsg
		
		
	}
	
	public void readMessage (Message msg) {
		
		String idOperation = msg.getIdOperation(), idClient = msg.getIdClient();
		
		if (idOperation.equals("030")) {
		
			this.createThreadServer(msg);
					
			// envia mensagem de volta para o cliente
			
			Message message = new Message();
			message.setIdOperation("001");
			message.setIdClient(msg.getIdClient());
			message.sendToClient(); // como?			
			
		} else if (idOperation.equals("042")) { // destroi thread server
			
			int idThread = Integer.parseInt(msg.getIdServer());
			this.destroyThreadServer(idThread);			
			
		} else if (idOperation.equals("040")) { // devolve tabela de score
			
			
						
		} else {
			
			System.out.println("operação invalida!");
			
		}		
	}
	
	public void createThreadServer (Message msg) {
		
		// cria thread servidora
		int index;
		this.threadServer.add(msg.getIdClient()); // string
		ServerClient serverClient = new ServerClient(msg.getIdClient());
		index = this.threadServer.indexOf(serverClient);	// int		
		serverClient.setIdServer(Integer.toString(index));
				
	}
	
	public void destroyThreadServer (int index) {
		
		this.threadServer.remove(index);
	}

	public ArrayList<String> getThreadServer() {
		return threadServer;
	}

	public void setThreadServer(ArrayList<String> threadServer) {
		this.threadServer = threadServer;
	}

	public ArrayList<String> getScoreThread() {
		return scoreThread;
	}

	public void setScoreThread(ArrayList<String> scoreThread) {
		this.scoreThread = scoreThread;	
	}
	

}