package logicGame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ServerMain {
	
	public ArrayList<Lista> listGlobal = new ArrayList();
	private int index = 0;
	
	public void ServerMain () {}
	
	public void wait_connection() {
		System.out.println("lola on");
		// ao verificar a chegada de uma msg 
		// chama o metodo readMsg		
		
	}
	
	public void readMessage (Message msg) {
		
		String idOperation = msg.getIdOperation(), idClient = msg.getIdClient();
		
		if (idOperation.equals("030")) {
		
			this.createThreadServer(msg,listGlobal);
					
			// envia mensagem de volta para o cliente
			
			Message message = new Message();
			message.setIdOperation("001");
			message.setIdClient(msg.getIdClient());
			message.sendToClient(); // como?			
			
		} else if (idOperation.equals("042")) { // destroi thread server
			
			int idThread = Integer.parseInt(msg.getIdServer());
			this.destroyThreadServer(msg);			
			
		} else if (idOperation.equals("040")) { // devolve tabela de score
			
			
						
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