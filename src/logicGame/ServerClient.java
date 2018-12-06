package logicGame;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ServerClient {
	
	private String idClient, idServer;
	private String nickClient;
	private ArrayList<Lista> list = new ArrayList();
	private Game game;
	
	public ServerClient (String idClient, ArrayList<Lista> lista) {
				
		this.idClient = idClient;
		this.idServer = idServer;
		this.list = lista;
	}	

	// general read method

	public void readMessage(Message msg) {
		
		String idOperation = msg.getIdOperation();
		
		if (idOperation.equals("002")) {
			
			serverDesconnectionOK ();
			
		} else if (idOperation.equals("003")) {
			
			serverFailConnection ();			
			
		} else if (idOperation.equals("004")) {
			
			serverTimeout ();			
			
		} else if (idOperation.equals("005")) {
			
			// pega da interface e passa pro programa
			String nick; // teste
			nick = "Lola"; // teste
			serverNickOk (nick);
			
		} else if (idOperation.equals("006")) {
			
			serverRefreshMain ();			
			
		} else if (idOperation.equals("007")) {
			
			serverNewGameOk();			
			
		} else if (idOperation.equals("008")) {
			
			serverListGameOk();			
			
		} else if (idOperation.equals("009")) {
			
			serverRefreshInfo();
			
		} else if (idOperation.equals("010")) {
			
			serverQuestionSend();			
			
		} else if (idOperation.equals("011")) {
			
			serverCorrectionSend();
			
		} else if (idOperation.equals("012")) {
			
			serverJumpOk();
			
		} else if (idOperation.equals("013")) {
			
			serverFinishGameOk();
			
		} else if (idOperation.equals("014")) {

			serverScore();
			
		} else if (idOperation.equals("015")) {

			serverExitOk();
			
		} else {
			
			System.out.println("Operação desconhecida");
			
		}		
	}
	
	// operation methods

	public void serverDesconnectionOK () {
	
		//solicitar retirada do servidor
	}
	
	
	public void serverFailConnection () {
		
		System.out.println("conexão não foi bem sucedida");
		
	}
	
	public void serverTimeout () {
		
		System.out.println("Tempo de conexão expirado!");
		
	}
	
	public void serverNickOk (String nick) {
		
		this.nickClient = nick;
		//******interface mostra o nome
		
	}
	
	public void serverRefreshMain () {
		
		// passa lista atual para interface
		// *** mostra this.list
		
	}
	public void serverNewGameOk() {
		
		// dificuldade 
		//recebe dificuldade de n de jogadores
		Game game = new Game();
		this.game = game;
	}
	
	public void serverListGameOk() {
		
		int players = this.game.getPlayersOn();
		// interface mostra numero de jogadores
		
	};
	
	public void serverRefreshInfo() {
		
		ArrayList<Client> number = this.game.getPlayers();
		// interface mostra jogadores na sala
		
	};
	
	public void serverQuestionSend() {};
	public void serverCorrectionSend() {};
	public void serverJumpOk() {};
	public void serverFinishGameOk() {};
	public void serverScore() {};
	public void serverExitOk() {};
	
	// Sets and getters
	
	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getIdServer() {
		return idServer;
	}

	public void setIdServer(String idServer) {
		this.idServer = idServer;
	}

}
