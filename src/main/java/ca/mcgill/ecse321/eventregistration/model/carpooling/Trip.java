package ca.mcgill.ecse321.eventregistration.model.carpooling;


public class Trip {
	
	private String id;
	private String d_id;
	private int seats;
	private String car_type;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	
	@Override
	public String toString() {
		return "Trip [id=" + id + ", d_id=" + d_id + ", seats=" + seats + ", car_type=" + car_type
				+ "]";
	}
	
	
}
