package logicGame;
import java.util.Random;

public class ServerClient {
	
	private int idClient, idServer;
	
	public int ServerClient (int idClient) {
				
		int id;
		Random generator = new Random();
		id = generator.nextInt(25);
		this.idClient = idClient;
		this.idServer = id;
		return id;
		
	}
	
	// metodos de mensagens
	
	public void connectionOk () {
		
		Message msg = new Message();
		
		
	};
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
