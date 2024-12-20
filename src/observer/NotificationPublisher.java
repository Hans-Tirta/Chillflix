package observer;

import java.util.ArrayList;

import model.Notification;
import model.user.Customer;
import model.user.User;

public class NotificationPublisher implements IObserver {

	private ArrayList<User> users = new ArrayList<>();

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public void removeUser(User user) {
		users.remove(user);
	}

	@Override
	public void notifyUsers(Notification notification) {
		for (User user : users) {
			user.addNotification(notification);
			sendEmailNotification(user, notification);
		}
	}

	@Override
	public void notifyFreeUsers(Notification notification) {
		// Notify only free customers
		for (User user : users) {
			if (user instanceof Customer) { // Check if the user is a Customer
				Customer customer = (Customer) user; // Cast to Customer
				if (customer.getSubscription().getClass().getSimpleName().equals("Free")) {
					customer.addNotification(notification);
					sendEmailNotification(customer, notification); // Optional: Send email notification
				}
			}
		}
	}

	@Override
	public void notifyPremiumUsers(Notification notification) {
		// Notify only premium customers
		for (User user : users) {
			if (user instanceof Customer) { // Check if the user is a Customer
				Customer customer = (Customer) user; // Cast to Customer
				if (customer.getSubscription().getClass().getSimpleName().equals("Premium")) {
					customer.addNotification(notification);
					sendEmailNotification(customer, notification); // Optional: Send email notification
				}
			}
		}
	}

	@Override
	public void sendEmailNotification(User user, Notification notification) {
		if (user instanceof Customer) {
			Customer customer = (Customer) user; // Safe cast to Customer
			System.out.println(
					"Sending notification to " + customer.getEmail() + " with message: " + notification.getMessage());
		}
	}

}
