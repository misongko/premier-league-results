package model.vo;

public class Results {
	private String opposingTeam;
	private int myScore;
	private int opposingScore;
	private String stadium;
	private char field;
	
	public Results() {}

	public Results(String opposingTeam, int myScore, int opposingScore, String stadium, char field) {
		super();
		this.opposingTeam = opposingTeam;
		this.myScore = myScore;
		this.opposingScore = opposingScore;
		this.stadium = stadium;
		this.field = field;
	}

	public String getOpposingTeam() {
		return opposingTeam;
	}
	public void setOpposingTeam(String opposingTeam) {
		this.opposingTeam = opposingTeam;
	}

	public int getMyScore() {
		return myScore;
	}
	public void setMyScore(int myScore) {
		this.myScore = myScore;
	}

	public int getOpposingScore() {
		return opposingScore;
	}
	public void setOpposingScore(int opposingScore) {
		this.opposingScore = opposingScore;
	}

	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public char getField() {
		return field;
	}
	public void setField(char field) {
		this.field = field;
	}
	
}
