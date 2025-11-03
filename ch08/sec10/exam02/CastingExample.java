package ch08.sec10.exam02;

public class CastingExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		
		Bus bus = (Bus) vehicle;
		bus.run();
		bus.checkFare();
		

		//타입 추론
//		var v = new Bus();
//		Sysout.out.println(v instanceof Vehicle);
	}
}