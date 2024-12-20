package view.admin;

import controller.UserController;
import model.Notification;
import model.user.Customer;
import model.user.User;
import observer.NotificationPublisher;

import java.util.Random;
import java.util.Scanner;

public class UserManagementView {
	private UserController userController = new UserController();
	private Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	public void displayMenu() {
		while (true) {
			System.out.println("\n=== Manage Users ===");
			System.out.println("1. View All Users");
			System.out.println("2. Delete User");
			System.out.println("3. Send Notification");
			System.out.println("4. Back");
			System.out.print(">> ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				viewAllUser();
				break;
			case 2:
				viewAllUser();
				deleteUser();
				break;
			case 3:
				sendNotificationMenu(); // Calls the Send Notification menu
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}

	private void sendNotificationMenu() {
		while (true) {
			System.out.println("\n=== Send Notification ===");
			System.out.println("1. Notify All Users");
			System.out.println("2. Notify Specific User by Email");
			System.out.println("3. Notify Free Users");
			System.out.println("4. Notify Premium Users");
			System.out.println("5. Back");
			System.out.print(">> ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				notifyAllUsers();
				break;
			case 2:
				notifySpecificUser();
				break;
			case 3:
				notifyFreeUsers();
				break;
			case 4:
				notifyPremiumUsers();
				break;
			case 5:
				return; // Back to the previous menu
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}

	private void viewAllUser() {
		System.out.println("\n=== User List ===");
		System.out.println("===================================================================");
		System.out.println("| ID   | Name              | Email                     | Role     |");
		System.out.println("===================================================================");
		for (User user : userController.getAllUsers()) {
			System.out.printf("| %-4d | %-17s | %-25s | %-8s |\n", user.getId(), user.getName(), user.getEmail(),
					user.getRole());
		}
		System.out.println("===================================================================");
	}

	private void deleteUser() {
		System.out.println("\n=== Delete User ===");
		System.out.print("Enter ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		if (userController.deleteUser(id)) {
			System.out.println("User deleted successfully!");
		} else {
			System.out.println("User not found!");
		}
	}

	private void notifyAllUsers() {
		String message, id;
		System.out.print("Input Message for All Users: ");
		message = scanner.nextLine();
		id = generateId();

		Notification notification = new Notification(id, message);

		NotificationPublisher notifPublisher = new NotificationPublisher();
		for (User user : userController.getAllUsers()) {
			notifPublisher.addUser(user);
		}
		notifPublisher.notifyUsers(notification);
	}

	private void notifySpecificUser() {
		viewAllUser();
		System.out.print("Enter user's email to notify: ");
		String userEmail = scanner.nextLine();

		User user = userController.getUserByEmail(userEmail);
		if (user != null) {
			System.out.print("Enter message for user: ");
			String message = scanner.nextLine();
			String id = generateId();
			Notification notification = new Notification(id, message);

			NotificationPublisher notifPublisher = new NotificationPublisher();
			notifPublisher.addUser(user);
			notifPublisher.notifyUsers(notification); // This will notify only the specific user
		} else {
			System.out.println("User not found!");
		}
	}

	private void notifyFreeUsers() {
		String message, id;
		System.out.print("Input Message for Free Users: ");
		message = scanner.nextLine();
		id = generateId();

		Notification notification = new Notification(id, message);

		NotificationPublisher notifPublisher = new NotificationPublisher();
		for (User user : userController.getAllUsers()) {
			if (user instanceof Customer) { // Check if user is a Customer
				Customer customer = (Customer) user;
				if (customer.getSubscription().getClass().getSimpleName().equals("Free")) {
					notifPublisher.addUser(user);
				}
			}
		}
		notifPublisher.notifyFreeUsers(notification);
	}

	private void notifyPremiumUsers() {
		String message, id;
		System.out.print("Input Message for Premium Users: ");
		message = scanner.nextLine();
		id = generateId();

		Notification notification = new Notification(id, message);

		NotificationPublisher notifPublisher = new NotificationPublisher();
		for (User user : userController.getAllUsers()) {
			if (user instanceof Customer) { // Check if user is a Customer
				Customer customer = (Customer) user;
				if (customer.getSubscription().getClass().getSimpleName().equals("Premium")) {
					notifPublisher.addUser(user);
				}
			}
		}
		notifPublisher.notifyPremiumUsers(notification);
	}

	public String generateId() {
		String prefix = "NO";
		int randomNumber = random.nextInt(1000);
		String formattedNumber = String.format("%03d", randomNumber);
		return prefix + formattedNumber;
	}
}
