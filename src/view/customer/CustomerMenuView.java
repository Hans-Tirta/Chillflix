package view.customer;

import java.util.Scanner;

import model.user.Customer;
import model.user.User;

public class CustomerMenuView {

	private Scanner scanner = new Scanner(System.in);
	private User loggedInUser;

	public CustomerMenuView(User user) {
		this.loggedInUser = user;
	}

	public void displayMenu() {

		while (true) {
			System.out.println("\n=== Customer Menu ===");
			System.out.println("1. Watch Content");
			System.out.println("2. Manage Playlist");
			System.out.println("3. Upgrade Subscription");
			System.out.println("4. Manage Account");
			System.out.println("5. Check My Notifications");
			System.out.println("6. Logout");
			System.out.print(">> ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				new ContentWatchView((Customer) loggedInUser).displayMenu();
				break;
			case 2:
				new PlaylistManagementView((Customer) loggedInUser).displayMenu();
				break;
			case 3:
				new SubscriptionManagementView((Customer) loggedInUser).displayMenu();
				break;
			case 4:
				new AccountManagementView(loggedInUser).displayMenu();
				break;
			case 5:
				loggedInUser.displayNotification();
				break;
			case 6:
				System.out.println("Logging out...");
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
