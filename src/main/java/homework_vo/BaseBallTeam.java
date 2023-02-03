package homework_vo;

import java.util.Map;
import java.util.Properties;

public class BaseBallTeam {
 private String tname;
 private int win;
 private int eq;
 private int def;
 private Properties hitplayers;
 private Map<String,String> defenceplayers;
 
 
 public void Teaminfo() {
	 System.out.println(tname+"팀 정보");
	 System.out.println("승:"+win+"\t무:"+eq+"\t패:"+def);
	 if(hitplayers!=null && defenceplayers!=null) {
		 System.out.println("타석명단:"+hitplayers);
		 System.out.println("수비명단:"+defenceplayers);
	 }
 }
 
public BaseBallTeam() {
}
public BaseBallTeam(String tname, int win, int eq, int def) {
	this.tname = tname;
	this.win = win;
	this.eq = eq;
	this.def = def;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public int getWin() {
	return win;
}
public void setWin(int win) {
	this.win = win;
}
public int getEq() {
	return eq;
}
public void setEq(int eq) {
	this.eq = eq;
}
public int getDef() {
	return def;
}
public void setDef(int def) {
	this.def = def;
}
public Properties getHitplayers() {
	return hitplayers;
}
public void setHitplayers(Properties hitplayers) {
	this.hitplayers = hitplayers;
}
public Map<String, String> getDefenceplayers() {
	return defenceplayers;
}
public void setDefenceplayers(Map<String, String> defenceplayers) {
	this.defenceplayers = defenceplayers;
}
 
 
}
