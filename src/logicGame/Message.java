package logicGame;
import java.sql.Timestamp;

public class Message {

	private String idServer = new String("00000000");
	private String idClient = new String("00000000");
	private String idGame = new String("0000");
	private String idOperation = new String("000");
	private int flagError = 0;
	private int flagDifficulty = 0;
	private int flagCorrection = 0;
	private int flagAnswer = 0;
	private Timestamp timestamp; // não pega o timestamp, só declara a variavel
	private String msg = new String();
    
    // cria a mensagem, envia, o outro recebe e destroi
    
	public void Message () {};
	
    public void Message(String idServer,String idClient,String idGame, String idOperation, int flagError, int flagDifficulty, int flagCorrection, int flagAnswer, Timestamp timestamp, String msg) {
    	
    	// setar as informações
    	
    	this.idServer = idServer;
    	this.idClient =  idClient;
    	this.idGame =  idGame;
    	this.idOperation = idOperation;
    	this.flagError = flagError;
    	this.flagDifficulty = flagDifficulty;
    	this.flagCorrection = flagCorrection;
    	this.flagAnswer =  flagAnswer;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.msg = msg;
          	
    	
    };
       
    public String getIdServer() {
		return idServer;
	}

	public void setIdServer(String idServer) {
		this.idServer = idServer;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getIdGame() {
		return idGame;
	}

	public void setIdGame(String idGame) {
		this.idGame = idGame;
	}

	public String getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}

	public int getFlagError() {
		return flagError;
	}

	public void setFlagError(int flagError) {
		this.flagError = flagError;
	}

	public int getFlagDifficulty() {
		return flagDifficulty;
	}

	public void setFlagDifficulty(int flagDifficulty) {
		this.flagDifficulty = flagDifficulty;
	}

	public int getFlagCorrection() {
		return flagCorrection;
	}

	public void setFlagCorrection(int flagCorrection) {
		this.flagCorrection = flagCorrection;
	}

	public int getFlagAnswer() {
		return flagAnswer;
	}

	public void setFlagAnswer(int flagAnswer) {
		this.flagAnswer = flagAnswer;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void sendToServer(){};
    public void sendToClient(){};    
	
}
