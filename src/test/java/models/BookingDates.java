package models;

public class BookingDates {
	
	private String checkin;
	private String checkout;
	
	//constructor
	public BookingDates(){
		
	}
	public BookingDates(String checkin, String checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	//Getter and Setter
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	//To string
	@Override
	public String toString() {
		return "BookingDates [checkin=" + checkin + ", checkout=" + checkout + "]";
	}
	
	

}
