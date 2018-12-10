package logicGame;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.time.Instant;

public class Game {
	
	int playersOn, numberPlayers, difficulty;
	//ArrayList<String> players = new ArrayList();
	//ArrayList<Integer> score = new ArrayList();
	int score1, score2;
	String host, invit = "nop";
	
	
	public int scoreRefresh(int score, int correction) {
				
			
		if (correction == 1) score = score + 100;
			
		if (correction != 1) score = score - 50;
		
		return score;
		
	}

	// getters and setters

	public void setPlayersOn(int playersOn) {
		this.playersOn = playersOn;
	}

	public int getNumberPlayers() {
		return numberPlayers;
	}

	public void setNumberPlayers(int numberPlayers) {
		this.numberPlayers = numberPlayers;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getInvit() {
		return invit;
	}

	public void setInvit(String invit) {
		this.invit = invit;
	}

	//usa threads para enviar as mensagens
}
