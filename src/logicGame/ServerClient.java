package logicGame;
import java.util.Random;

public class ServerClient {
	
	private String idClient, idServer;
	
	public ServerClient (String idClient) {
				
		this.idClient = idClient;		
	}	
	
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

	// general read method

	public void readMessage(Message msg) {
		
		String idOperation = msg.getIdOperation();
		
		if (idOperation.equals("030")) {
			
		} else if (idOperation.equals("031")) {
			
			
		} else if (idOperation.equals("032")) {
			
			
		} else if (idOperation.equals("033")) {
			
			
		} else if (idOperation.equals("034")) {
			
			
		} else if (idOperation.equals("035")) {
			
			
		} else if (idOperation.equals("036")) {
			
			
		} else if (idOperation.equals("037")) {
			
			
		} else if (idOperation.equals("038")) {
			
			
		} else if (idOperation.equals("039")) {
			
			
		} else if (idOperation.equals("040")) {
			
			
		} else if (idOperation.equals("041")) {
			
			
		} else if (idOperation.equals("042")) {
			
			
		} else {
			
			System.out.println("Operação desconhecida");
			
		}		
	}
	
	// operation methods

	public void desconnectionOK () {};
	public void serverFailConnection () {};
	public void serverTimeout () {};
	public void serverNickOk () {};
	public void serverRefreshMain () {};
	public void serverNewGameOk() {};
	public void serverListGameOk() {};
	public void serverRefreshInfo() {};
	public void serverQuestionSend() {};
	public void serverCorrectionSend() {};
	public void serverJumpOk() {};
	public void serverFinishGameOk() {};
	public void serverScore() {};
	public void serverExitOk() {};

}
