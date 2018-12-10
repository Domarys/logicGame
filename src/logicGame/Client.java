package logicGame;

import java.util.Random;

public class Client {
	
	// interface (Gabriella)
	
	private int idClient, idServer, idHost;
	String nick = new String();
	
	public void Client () {
				
		int id, cnt;
		Random generator = new Random();
		id = generator.nextInt(25);
		this.idClient = id;
		
		Message msg = new Message();
		msg.setIdClient(Integer.toString(id));
		
		// solicita conexão com o server

		//cnt = this.clientConnection();
		
	}
	
	
	
	// metodos das mensagens
	
	public int getIdClient() {
		return idClient;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	public int getIdServer() {
		return idServer;
	}



	public void setIdServer(int idServer) {
		this.idServer = idServer;
	}



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}



	public void clientConnection () {
		
		int ret = 0;
		
		// faz a conexão TCP
		
		if (ret == 0) {
			
			// tela erro
			
		}
				
	};
	
	public void clientRequestNick () {
		
		int ret = 0;
		
		// pega o nick do usuario
		
		this.nick = nick;
		
		// envia para o servidor
		
		if (ret == 0) {
			
			// erro
			
		}
			
	};
	
	
	public void clientRequestRefresh () {};
	public void clientRequestNewGame  () {};
	public void clientRequestInGame () {};
	public void clientRequestInfoGame () {};
	public void clientRequestQuestion () {};
	public void clientRequestCorrection () {};
	public void clientequestPush () {};
	public void clientRequestFinishGame () {};
	public void clientRequestScore () {};
	public void clientRequestExit () {};
	
	
}
