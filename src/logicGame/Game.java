package logicGame;

import java.util.ArrayList;

public class Game {
	
	int playersOn, numberPlayers, difficulty;
	ArrayList<Client> players = new ArrayList();
	
	public Game() {
		
	}
	
	public int onGame () {
		
		int ok=0;
		if (players.size() != numberPlayers) ok =1;
		
		return ok;
		
	}

	// getters and setters
	
	public int getPlayersOn() {
		return this.players.size();
	}

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

	public ArrayList<Client> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Client> players) {
		this.players = players;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	//usa threads para enviar as mensagens
}
