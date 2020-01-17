package fr.eni.navale.bo;

public class Etat {
	private String symbol;
	
	public Etat(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
}
