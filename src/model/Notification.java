package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
	private String id;
	private String message;
	private String timeSent;

	public Notification(String id, String message) {
		super();
		this.id = id;
		this.message = message;
		this.timeSent = getCurrentTime();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(String timeSent) {
		this.timeSent = timeSent;
	}

	private String getCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.now().format(formatter);
	}

}
