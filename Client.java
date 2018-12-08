package logicGame;

import java.util.Random;
import logicGame.Message;

public class Client {
	
	// interface (Gabriella)
	
	private int idClient, idServer, dificuldade; // guarda a dificuldade que o cliente escolheu 
	String nick = new String();
        private int tmt=3;
	public void Client () {
				
		int id, cnt;
		Random generator = new Random();
		id = generator.nextInt(25);
		this.idClient = id;
		
		Message msg = new Message();
		msg.setIdClient(Integer.toString(id));
                
                //  parte grafica
                
		
		// solicita conexão com o server

		//cnt = this.clientConnection();
		
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



	public void clientConnection () {
		
               Message m = new Message(); 
             m.setIdOperation("030");
		int ret = 0;
		
		// faz a conexão TCP
		
		if (ret == 0) {
			
			// tela erro
			
		}
				
	};
	
	public void clientRequestNick () {
		
		int ret = 0;
		
		// pega o nick do usuario
		
		//this.nick = nick;
		   Message m = new Message(); 
             m.setIdOperation("031");
             m.setMsg(this.nick);
		// envia para o servidor
		
		if (ret == 0) {
			
			// erro
			
		}
			
	};
	public int getDif(){
            return this.dificuldade;
        }
	
	public void clientRequestRefresh () {
            // carrega dela das salas de tanto em tanto tempo
//             só volta para a tela de opções
            
        };
	public void clientRequestNewGame  () {
            // tavlez quando der o click  
             // pega a dificuldade selecionada na interface
           
             Message m = new Message(); 
             m.setIdOperation("033");
             m.setFlagDifficulty(this.dificuldade);
             // mandar obketo m
        
        };
	public void clientRequestInGame () {
        Message m = new Message(); 
           m.setIdOperation("034");
//           clicou no ingame e está esperando para entrar em uma sala
        };
	public void clientRequestInfoGame () {
        Message m = new Message(); 
           m.setIdOperation("035");
           //setar as salas
        };
	public void clientRequestQuestion () {
        Message m = new Message();
          m.setIdOperation("036");
//          setar pergunta no painel
        };
	public void clientRequestCorrection () {
        Message m = new Message(); 
         m.setIdOperation("037");
         m.setMsg(" o que vem do painel");
        };
	public void clientequestPush () {
            Message m = new Message();
            m.setIdOperation("038");
        };
	public void clientRequestFinishGame () {
        Message m = new Message(); 
         m.setIdOperation("039");
        };
	public void clientRequestScore () {
        Message m = new Message();
         m.setIdOperation("040");
        };
	public void clientRequestExit () {
        // solicita encerrar conexao volta para a  tela inicial
        Message m = new Message(); 
         m.setIdOperation("042");
        };
	public void clientRequestDesconnection(){
            Message m = new Message(); 
         m.setIdOperation("042");
        };
        
        
         public static void main(String[] args) {
           Client c = new Client();
            Janela tela = new Janela(c);
             tela.setVisible(true);
         }
	
}
