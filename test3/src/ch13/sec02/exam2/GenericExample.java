package ch13.sec02.exam2;

public class GenericExample {

	public static void main(String[] args) {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnlight();
		
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();

	}

}
