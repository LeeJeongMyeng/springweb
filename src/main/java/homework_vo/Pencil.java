package homework_vo;

public class Pencil {
	private String name;
	private Eraser eraser;
	public Pencil() {
	}
	public Pencil(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Eraser getEraser() {
		return eraser;
	}
	public void setEraser(Eraser eraser) {
		this.eraser = eraser;
	}
	
	
}
