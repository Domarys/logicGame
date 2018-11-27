package logicGame;

import java.util.Random;

public class Client {
	
	// interface (Gabriella)
	
	private int idClient, idServer;
	
	public void Client () {
				
		int id;
		Random generator = new Random();
		id = generator.nextInt(25);
		this.idClient = id;
		// solicita conexão com o server
		
		Message msg = new Message();
		
		
	}
	
	// metodos das mensagens
	
	public void clientRequestNick () {};
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
