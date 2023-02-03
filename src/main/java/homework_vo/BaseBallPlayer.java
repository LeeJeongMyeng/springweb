package homework_vo;

public class BaseBallPlayer {
//이름, 팀명, 타율
	private String name;
	private String tname;
	private double xkdbf;
	private BaseBallTeam bbt;
	
	public BaseBallPlayer() {
	}
	
	public void score() {
		System.out.println("<"+name+"선수 정보>");
		
		System.out.println("타율:"+xkdbf);
		if(bbt!=null) {
			System.out.println("<해당선수의 팀정보>");
			System.out.println("팀명:"+bbt.getTname());
			System.out.println("승:"+bbt.getWin());
			System.out.println("무:"+bbt.getEq());
			System.out.println("패:"+bbt.getDef());
		}else {
		System.out.println("현재는 팀이 없습니다.");	
		}
	}
	
	
	
	public BaseBallPlayer(String name, String tname, double xkdbf) {
		this.name = name;
		this.tname = tname;
		this.xkdbf = xkdbf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public double getXkdbf() {
		return xkdbf;
	}
	public void setXkdbf(double xkdbf) {
		this.xkdbf = xkdbf;
	}
	public BaseBallTeam getBbt() {
		return bbt;
	}
	public void setBbt(BaseBallTeam bbt) {
		this.bbt = bbt;
	}
	
	
}
