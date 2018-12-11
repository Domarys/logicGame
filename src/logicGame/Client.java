package logicGame;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import javax.swing.JLabel;
import logicGame.Message;

public class Client {

    public Client(Socket socket) {
    }
	
	// interface (Gabriella)
	
	private int idClient, idServer, dificuldade; // guarda a dificuldade que o cliente escolheu 
	String nick = new String();
        Socket socket_client, socket_jogo;
        private int tmt=3;
        private String pergunta, resposta, resp_cli;
        private int flagAnswer,flagCorrection;
        private int numPartidas;
	public void Client (Socket socket) throws IOException {
                this.numPartidas =0;
		int id, cnt;
		Random generator = new Random();
		id = generator.nextInt(25);
		this.idClient = id;
		this.socket_client = socket;
		Message msg = new Message();
		msg.setIdClient(Integer.toString(id));
                
                //  parte grafica
                
		
		// solicita conexão com o server

		//cnt = this.clientConnection();
		
	}
        public void incrementaNumPartidas(){
            this.numPartidas++;
        }
        public int getNumPartidas(){
            return this.numPartidas;
        }
	public void setTimestamp(int tempo){
            this.tmt = tempo;
        }
	public void setDificuldade(int d){
            this.dificuldade = d;
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
        public String getResp_cli() {
		return this.resp_cli;
	}



	public void setResp_cli(String resp) {
		this.resp_cli = resp;
	}
                public String enviaPerguntaTela(){
            return this.pergunta;
        }

        public void setFlagAnswer(int flag){
            this.flagAnswer  = flag;
        }
        public int getFlagCorrection(){
            return this.flagCorrection;
        }
        public void setFlagCorrection(int co){
            this.flagCorrection = co;
        }
        
           // MANDAR E RECEBER OBJETO DAQUI PARA BAIXO

	public void clientConnection () throws IOException {
		 ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(this.socket_client.getInputStream());
               Message m = new Message(); 
             m.setIdOperation("030");
		 output.writeObject(m);
            output.flush();
            output.close();
		
	};
	
	public void clientRequestNick () throws IOException {
            ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
            Message m = new Message(); 
            m.setIdOperation("031");
            m.setMsg(this.nick);
            output.writeObject(m);
            output.flush();
            output.close();
			
	};
	public int getDif(){
            return this.dificuldade;
        }
	
	public void clientRequestRefresh () throws IOException {
            ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
             Message m = new Message(); 
             m.setIdOperation("032");
            output.writeObject(m);
            output.flush();
            output.close();
            // carrega dela das salas de tanto em tanto tempo
//             só volta para a tela de opções
            
        };
	public void clientRequestNewGame  () throws IOException {
            // tavlez quando der o click  
             // pega a dificuldade selecionada na interface
             ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
             Message m = new Message(); 
             m.setIdOperation("033");
             m.setFlagDifficulty(this.dificuldade);
              output.writeObject(m);
            output.flush();
            output.close();
        
        };
	public void clientRequestInGame () throws IOException {
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
        Message m = new Message(); 
           m.setIdOperation("034");
//           clicou no ingame e está esperando para entrar em uma sala
        };
	public void clientRequestInfoGame () throws IOException {
            ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(this.socket_client.getInputStream());
            Message m = new Message(); 
            m.setIdOperation("035");
            output.writeObject(m);
            output.flush();
            output.close();
            // recebe informações como elas estão chegando
           //setar as salas
        };
	public void clientRequestQuestion () throws IOException, ClassNotFoundException {
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
              ObjectInputStream input = new ObjectInputStream(this.socket_client.getInputStream());
              Message m = new Message();
          m.setIdOperation("036");
          output.writeObject(m);
            output.flush();
            output.close();
           m = (Message) input.readObject();
            this.pergunta = m.getMsg();
           input.close();
        };
	public boolean clientRequestCorrection () throws IOException, ClassNotFoundException {
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
        Message m = new Message(); 
         m.setIdOperation("037");
         switch(this.resp_cli){
             case "A":
                m.setFlagAnswer(1);
             break;
             case "B":
                m.setFlagAnswer(2);
             break;
             case "C":
                 m.setFlagAnswer(3);
             break;
             case "D":
                 m.setFlagAnswer(4);
             break;
             case "E":
                 m.setFlagAnswer(5);
             break;
             default:
                 m.setFlagAnswer(0);
                 m.setMsg(this.resp_cli);
             break;  
         }
         output.writeObject(m);
            output.flush();
            output.close();
        ObjectInputStream input = new ObjectInputStream(this.socket_client.getInputStream());
         m = (Message) input.readObject();
            this.flagCorrection = m.getFlagCorrection();
           input.close();
        return true;
        };
	public void clientequestPush () throws IOException {
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
            Message m = new Message();
            m.setIdOperation("038");
            output.writeObject(m);
            output.flush();
            output.close();
        };
	public void clientRequestFinishGame () throws IOException {
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
        Message m = new Message(); 
         m.setIdOperation("039");
         output.writeObject(m);
            output.flush();
            output.close();
        };
	public void clientRequestScore () throws IOException {
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
        Message m = new Message();
         m.setIdOperation("040");
         output.writeObject(m);
            output.flush();
            output.close();
        };
	public void clientRequestExit () throws IOException {
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
        // solicita encerrar conexao volta para a  tela inicial
        Message m = new Message(); 
         m.setIdOperation("042");
         output.writeObject(m);
            output.flush();
            output.close();
        };
	public void clientRequestDesconnection() throws IOException{
              ObjectOutputStream output = new ObjectOutputStream(this.socket_client.getOutputStream());
            Message m = new Message(); 
         m.setIdOperation("042");
         
         output.writeObject(m);
            output.flush();
            output.close();
        };
        
        
         public static void main(String[] args) throws IOException {
             String ip = "localhost";
              try (Socket socket = new Socket(ip, 2345)) {
                Client c = new Client(socket);
                Janela tela = new Janela(c);
                tela.setVisible(true);
               }
         }
	
}
