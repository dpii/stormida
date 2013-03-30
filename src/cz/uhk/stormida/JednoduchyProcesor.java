package cz.uhk.stormida;

import java.util.StringTokenizer;

public class JednoduchyProcesor implements Procesor {
	
	public double getVysledek(String vyraz) {
		StringTokenizer stOp = new StringTokenizer(vyraz, ".0123456879");
		
		StringTokenizer stHodnoty = new StringTokenizer(vyraz, "/*-+");
		
		double vysledek = Double.parseDouble(stHodnoty.nextToken());
		
		while (stOp.hasMoreTokens()) {
			
			char op = stOp.nextToken().charAt(0);
			
			double h = Double.parseDouble(stHodnoty.nextToken());  
			
			switch (op) {
				case '+': vysledek += h;break;
				case '-': vysledek -= h;break;
				case '*': vysledek *= h;break;
				case '/': vysledek /= h;break;
			}
		}
		return vysledek;
	}
}
