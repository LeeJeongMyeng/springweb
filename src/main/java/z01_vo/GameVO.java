package z01_vo;

import java.util.Date;

public class GameVO {
	private String name;
	private int score;
	private String date;
	public GameVO() {
	}
	
	public GameVO(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public GameVO(String name, int score, String date) {
		this.name = name;
		this.score = score;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
