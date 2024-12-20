package model.user;

import java.util.ArrayList;

import model.Notification;

public class User {
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	protected String role;
	private ArrayList<Notification> notifications;

	public User(int id, String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.notifications = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(ArrayList<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return id + " | " + name + " | " + email + " | " + role;
	}

	public void addNotification(Notification notification) {
		notifications.add(notification);
	}

	public void displayNotification() {
		System.out.println("");
		System.out.println("=== My Notifications ===");
		int i = 1;
		for (Notification n : notifications) {
			System.out.println(i + ". ID: " + n.getId());
			System.out.println("Message: " + n.getMessage());
			System.out.println("Time Sent: " + n.getTimeSent());
			System.out.println("");
			i++;
		}
	}

}
