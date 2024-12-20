package view.admin;

import java.util.Scanner;

import model.user.User;

public class AdminMenuView {

	private Scanner scanner = new Scanner(System.in);
	private User loggedInUser;

	public AdminMenuView(User user) {
		this.loggedInUser = user;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n=== Admin Menu ===");
			System.out.println("1. Manage Content");
			System.out.println("2. Manage Users");
			System.out.println("3. Logout");
			System.out.print(">> ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				new ContentManagementView().displayMenu();
				break;
			case 2:
				new UserManagementView().displayMenu();
				break;
			case 3:
				System.out.println("Logging out...");
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
