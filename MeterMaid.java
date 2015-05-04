package transportAuthority;

public class MeterMaid {
	private String m_name;
	
	MeterMaid(String name) {
		m_name = name;
		}
	public static String revealName(MeterMaid name) {
		return name.m_name;
		}
	
	public static void checkCar(String licensePlate, Authority amt, MeterMaid name) {
		int points = new java.util.Random().nextInt(3);
		double fee = (double)(new java.util.Random().nextInt(90) + 10);
		String politesse = MeterMaid.revealName(name);
		Authority.registerDelict(licensePlate, fee, points, amt, politesse ); 
		}
	
	public static void printTicket (String nummernschild, Authority amt) {
		Car dieses = Authority.findCar(nummernschild, amt);
		if (dieses == null) return;
		String[] politessen = Car.getControls(dieses);
		if (politessen==null) {System.out.println("Es liegen keine Delikte vor"); return;}
		int[] punkte = Car.getPoints(dieses);
		double[] fees = Car.getFees(dieses);
		System.out.println("Strafzettel");
		System.out.println("Name: " + Car.reportOwner(dieses));
		System.out.println("wohnhaft: "+ Car.reportAddress(dieses));
		System.out.println("Kennzeichen: "+ Car.reportLicensePlate(dieses));
		System.out.println("Strafen: " + java.util.Arrays.toString(fees)); 
		System.out.println("Punkte:  " + java.util.Arrays.toString(punkte));
		double betrag=0;
		int gesamtpunkte=0; 
		for (int i=0; i<punkte.length; i++) {
			betrag+=fees[i];
			gesamtpunkte+=punkte[i]; 
			}
		for (int i=0; i<politessen.length; i++) System.out.println("Kontrolle "+(i+1)+ " durch: " +politessen[i]);
		System.out.println("Ihre Gesamtrechnung: " + betrag + " Euro");
		System.out.println("Sie haben " + gesamtpunkte + " Punkte gesammelt.");
		System.out.println();
	}
}
