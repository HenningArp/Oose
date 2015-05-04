package transportAuthority;

public class Car {
	private String c_licensePlate;
	private String c_owner;
	private String c_address;
	private double[] c_fees;
	private int[] c_points;
	private int c_numberOfDelicts;
	private String[] c_controlledBy;
	
	Car (String licensePlate, String owner, String address) {
		c_licensePlate = licensePlate;
		c_owner = owner;
		c_address = address;
		c_fees = new double[500];
		c_points = new int[500];
		c_numberOfDelicts=0;
		c_controlledBy = new String[500];
		} 
	
	public static String reportOwner (Car gesucht) {
		return gesucht.c_owner;
		}
	public static String reportLicensePlate (Car gesucht) {
		return gesucht.c_licensePlate;
		}
	public static String reportAddress(Car gesucht) {
		return gesucht.c_address;
		}
	public static int[] getPoints(Car gesucht) {
		int[] punkte;
		if (gesucht.c_numberOfDelicts==0) {
			punkte = new int[1];
			return punkte;
			}
		punkte = new int[gesucht.c_numberOfDelicts];
		for (int i=0; i< gesucht.c_numberOfDelicts; i++) punkte[i] = gesucht.c_points[i];
		return punkte;
		}
	public static double[] getFees(Car gesucht) {
		double [] fees;
		if (gesucht.c_numberOfDelicts==0) {
			fees = new double[1];
			return fees;
			}
		fees = new double[gesucht.c_numberOfDelicts];
		for (int j=0; j<gesucht.c_numberOfDelicts; j++) fees[j] = gesucht.c_fees[j];
		return fees;
		}
	public static String[] getControls (Car gesucht) {
		String[] politessen;
		if (gesucht.c_numberOfDelicts==0) return null;
		politessen = new String[gesucht.c_numberOfDelicts];
		for (int i=0; i<gesucht.c_numberOfDelicts; i++) politessen[i]=gesucht.c_controlledBy[i];
		return politessen;
		}
	public static void addDelict(Car gesucht, double fee, int points, String politesse) {
		if (fee==0) return;
		gesucht.c_controlledBy[gesucht.c_numberOfDelicts] = politesse;
		gesucht.c_fees[gesucht.c_numberOfDelicts] = fee;
		gesucht.c_points[gesucht.c_numberOfDelicts] = points;
		gesucht.c_numberOfDelicts++;
		}
	
	}
