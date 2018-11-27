package logicGame;
import java.sql.Timestamp;

public class Message {

	private String idThread = new String("00000000");
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
    
    public void Message(String idThread,String idClient,String idGame, String idOperation, int flagError, int flagDifficulty, int flagCorrection, int flagAnswer, Timestamp timestamp, String msg) {
    	
    	// setar as informações
    	
    	this.idThread = idThread;
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
    
    public void sendToServer(){};
    public void sendToClient(){};    
	
}
