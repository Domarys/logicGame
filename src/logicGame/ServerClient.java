package logicGame;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.Timestamp;
import java.time.Instant;

public class ServerClient {
	
	private String idClient, idServer, idInvit;
	private String nickClient;
	private ArrayList<Lista> list = new ArrayList();
	private Game game;
	private Test question;
	int difficulty, begin =0, round=0, index=0;
	Timestamp timestamp;
	
	public ServerClient (String idClient, ArrayList<Lista> lista) {
				
		this.idClient = idClient;
		this.idServer = String.valueOf(index);
		this.list = lista;
		index = index+1;
	}	

	// general read method

	public void readMessage(Message msg) {
		
		String idOperation = msg.getIdOperation();
		
		if (idOperation.equals("002")) {
			
			this.serverDesconnectionOK ();
			
		} else if (idOperation.equals("003")) {
			
			this.serverFailConnection ();			
			
		} else if (idOperation.equals("004")) {
			
			this.serverTimeout ();			
			
		} else if (idOperation.equals("005")) {
			
			// pega da interface e passa pro programa
			String nick; // teste
			nick = "Lola"; // teste
			this.nickClient = nick;
			serverNickOk (nick);
			
		} else if (idOperation.equals("006")) {
			
			this.serverRefreshMain ();			
			
		} else if (idOperation.equals("007")) {
			
			this.serverNewGameOk(msg);			
			
		} else if (idOperation.equals("008")) {
			
			this.serverInGameOk(msg);			
			
		} else if (idOperation.equals("009")) {
			
			this.serverRefreshInfo();
			
		} else if (idOperation.equals("010")) {
			
			this.serverQuestionSend();			
			
		} else if (idOperation.equals("011")) {
			
			this.serverCorrectionSend();
			
		} else if (idOperation.equals("012")) {
			
			this.serverJumpOk();
			
		} else if (idOperation.equals("013")) {
			
			this.serverFinishGameOk();
			
		} else if (idOperation.equals("014")) {

			this.serverScore(msg);
			
		} else if (idOperation.equals("015")) {

			this.serverExitOk();
			
		} else {
			
			System.out.println("Operação desconhecida");
			
		}		
	}
	
	// operation methods

	public void serverDesconnectionOK () {
		
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("002");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);	}
	
	
	public void serverFailConnection () {
		
		String m = "Falha na conexão!";
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("003");
		msg.setFlagError(1);
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
		msg.setMsg(m);
		
	}
	
	public void serverTimeout () {
		
		String m = "Tempo de conexão expirado!";
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("004");
		msg.setFlagError(1);
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);
		msg.setMsg(m);
	
	}
	
	public void serverNickOk (String nick) {
		
		this.nickClient = nick;
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("005");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
	}
	
	public void serverRefreshMain () {
		
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("006");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);
		//mandar array
		
	}
	public void serverNewGameOk(Message m) {	
		
		//  
		Game game = new Game();
		this.game = game;
		this.setDifficulty(m.getFlagDifficulty());
		game.difficulty = m.getFlagDifficulty();
		game.setHost(idClient);
		game.setScore1(000);
		Test question = new Test();
		this.question = question;
		// prepara a mensagem
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("007");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
	}
	
	public void serverInGameOk(Message m) {
		
		// prepara a mensagem
		this.game.setInvit(idInvit);
		this.game.setScore2(000);
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("007");
		timestamp = new Timestamp(System.currentTimeMillis());
		
	}
	
	public void serverRefreshInfo() {
		
		// como mandar o array
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("009");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
		
	}
	
	public void serverQuestionSend() {
		
		String m = this.question.getPergunta();
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("010");
		msg.setFlagAnswer(1);
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
		msg.setMsg(m);
		
		Message msgI = new Message();
		msgI.setIdServer(this.idServer);
		msgI.setIdClient(this.idClient);
		msgI.setIdOperation("010");
		msgI.setFlagAnswer(1);
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
		msgI.setMsg(m);
		
	}
	
	public void serverCorrectionSend() {
		
		String m = this.question.getResposta();
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("011");
		msg.setFlagAnswer(1);
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
		msg.setMsg(m);
		
		Message msgI = new Message();
		msgI.setIdServer(this.idServer);
		msgI.setIdClient(this.idClient);
		msgI.setIdOperation("011");
		msgI.setFlagAnswer(1);
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
		msgI.setMsg(m);		
	}
	
	public void serverJumpOk() {
		
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("012");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
	}
	
	public void serverFinishGameOk() {
		
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("013");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);
		// tirar do array
	}
	
	public void serverScore(Message m) {
		
		int s1, s2;
		s1 = this.game.scoreRefresh(this.game.getScore1(), m.getFlagCorrection());
		s2 = this.game.scoreRefresh(this.game.getScore2(), m.getFlagCorrection());
		this.round++;

		if (this.round == 10) {
			
			String ms = "Jogador1: "+this.game.getScore1()+"Jogador2: "+this.game.getScore2()+".";
			Message msg = new Message();
			msg.setIdServer(this.idServer);
			msg.setIdClient(this.idClient);
			msg.setIdOperation("014");
			msg.setFlagAnswer(1);
			timestamp = new Timestamp(System.currentTimeMillis());
			msg.setTimestamp(timestamp);		
			msg.setMsg(ms);
			this.serverFinishGameOk();			
		}		
	}
	
	public void serverExitOk() {
		
		Message msg = new Message();
		msg.setIdServer(this.idServer);
		msg.setIdClient(this.idClient);
		msg.setIdOperation("015");
		timestamp = new Timestamp(System.currentTimeMillis());
		msg.setTimestamp(timestamp);		
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

	public String getIdInvit() {
		return idInvit;
	}

	public void setIdInvit(String idInvit) {
		this.idInvit = idInvit;
	}

	public String getNickClient() {
		return nickClient;
	}

	public void setNickClient(String nickClient) {
		this.nickClient = nickClient;
	}

	public ArrayList<Lista> getList() {
		return list;
	}

	public void setList(ArrayList<Lista> list) {
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Test getQuestion() {
		return question;
	}

	public void setQuestion(Test question) {
		this.question = question;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}	

}
