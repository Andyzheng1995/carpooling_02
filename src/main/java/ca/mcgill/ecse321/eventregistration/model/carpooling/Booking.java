package ca.mcgill.ecse321.eventregistration.model.carpooling;

public class Booking {
	
	private String id;
	private String p_id;
	private String d_id;
	private double p_score;
	private double d_score;
	private String start;
	private String destination;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public double getP_score() {
		return p_score;
	}
	public void setP_score(double p_score) {
		this.p_score = p_score;
	}
	public double getD_score() {
		return d_score;
	}
	public void setD_score(double d_score) {
		this.d_score = d_score;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
