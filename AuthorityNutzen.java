package transportAuthority;

public class AuthorityNutzen {

	public static void main(String[] args) {
		
		MeterMaid[] politessen;
		Authority[] amt;
		politessen = new MeterMaid[10];
		amt = new Authority[3];
		amt[0] = new Authority();
		
		politessen[0] = new MeterMaid("Annegret Hausen");
		politessen[1] = new MeterMaid("Eusebia Gerstenkorn");
		String nummernschild = "BN JE 103";
		String halter = "Dr. Annemarie Schmitz";
		String wohnort = "Poppelsdorfer Aller 85, 53115 Bonn";
		Authority.addCar(nummernschild, halter, wohnort, amt[0]);
		Car audi;
		audi = new Car("BN A 200", "Eugen Baumgartner", "Albertus Magnus Platz 1, 50111 Köln");
		amt[1] = new Authority(audi);
		for (int i=0;  i<3; i++) {
			MeterMaid.checkCar(nummernschild, amt[0], politessen[0]);
			MeterMaid.checkCar("BN A 200", amt[1], politessen[1]);
			}
		MeterMaid.printTicket("BN JE 103", amt[0]);
		MeterMaid.printTicket("BN A 200", amt[1]);
	}

}
