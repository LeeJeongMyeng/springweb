package z01_vo;

public class Team {
	
	private String teamname;
	private int win;
	private int qe;
	private int def;
	private int point;
	
	
	public Team() {
	}
	public Team(String teamname, int win, int qe, int def, int point) {
		this.teamname = teamname;
		this.win = win;
		this.qe = qe;
		this.def = def;
		this.point = point;
	}
	
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getQe() {
		return qe;
	}
	public void setQe(int qe) {
		this.qe = qe;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
