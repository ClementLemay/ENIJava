package fr.eni.annuaire;

public class Materiel implements Numerotable{

	private int no;
	
	private String type;

	public Materiel(int no, String type) {
		super();
		this.no = no;
		this.type = type;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Materiel [no=" + no + ", type=" + type + "]";
	}
	
	
	
}
