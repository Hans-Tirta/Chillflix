package model.subscription;

public class Subscription {
	private String type;
	private double price;
	private String duration;

	public Subscription(String type, double price, String duration) {
		super();
		this.type = type;
		this.price = price;
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
