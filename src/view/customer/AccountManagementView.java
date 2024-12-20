package view.customer;

import controller.UserController;
import model.user.Customer;
import model.user.User;

import java.util.Scanner;

public class AccountManagementView {

	private Scanner scanner = new Scanner(System.in);
	private UserController userController = new UserController();

	private User loggedInUser;

	public AccountManagementView(User user) {
		this.loggedInUser = user;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n=== Account Management ===");
			System.out.println("1. View Profile");
			System.out.println("2. Update Profile");
			System.out.println("3. Delete Profile");
			System.out.println("4. Back to Main Menu");
			System.out.print(">> ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				viewProfile();
				break;
			case 2:
				viewProfile();
				updateProfile();
				break;
			case 3:
				viewProfile();
				if (deleteProfile()) {
					System.out.println("Profile deleted. Logging out...");
					return;
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	private void viewProfile() {
		Customer customer = (Customer) userController.getUserById(loggedInUser.getId());
		if (customer == null) {
			System.out.println("Error: User profile not found.");
		} else {
			System.out.println("\n=== Profile Details ===");
			System.out.println("ID: " + customer.getId());
			System.out.println("Name: " + customer.getName());
			System.out.println("Email: " + customer.getEmail());
		}
	}

	private void updateProfile() {
		scanner.nextLine(); // Consume newline
		System.out.print("Enter new name: ");
		String name = scanner.nextLine();
		System.out.print("Enter new email: ");
		String email = scanner.nextLine();
		System.out.print("Enter new password: ");
		String password = scanner.nextLine();

		boolean isUpdated = userController.updateCustomer(loggedInUser.getId(), name, email, password);
		if (isUpdated) {
			System.out.println("Profile updated successfully.");
		} else {
			System.out.println("Error: Profile update failed.");
		}
	}

	private boolean deleteProfile() {
		System.out.print("Are you sure you want to delete your profile? (y/n): ");
		char confirm = scanner.next().toLowerCase().charAt(0);
		if (confirm == 'y') {
			return userController.deleteUser(loggedInUser.getId());
		}
		return false;
	}
}
