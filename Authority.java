package transportAuthority;

public class Authority {
	private Car[] a_authorityInventory;
	private int a_numberOfCars;
	Authority () {
		a_authorityInventory = new Car[1000];
		a_numberOfCars = 0;
		}
	Authority (Car newCar) {
		a_authorityInventory = new Car[1000];
		a_authorityInventory[0] = newCar;
		a_numberOfCars = 1;
		}
	public static void  addCar (String nummernschild, String halter, String anschrift, Authority amt) {
		amt.a_authorityInventory[amt.a_numberOfCars] = new Car(nummernschild, halter, anschrift);
		amt.a_numberOfCars++;
		}
	public static Car findCar(String licensePlate, Authority amt) {
		int i;
		for (i=0; i<amt.a_numberOfCars; i++) if (Car.reportLicensePlate(amt.a_authorityInventory[i]) == licensePlate) break;
		if (i==amt.a_numberOfCars) {
			System.out.println("The car you're looking for is temporally not available");
			return null;
			}
		return  amt.a_authorityInventory[i];
		}
	
	public static void registerDelict(String licensePlate, double fee, int points, Authority amt, String name) {
		Car current = findCar(licensePlate, amt);
		if (current==null) {
			return;
			}
		
		Car.addDelict(current, fee, points, name);
	}
}