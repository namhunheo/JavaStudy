package ch13.sec02.exam2;

public class HomeAgency implements Rentable<Home> {
	@Override
	public Home rent() {
		return new Home();
	}
}
