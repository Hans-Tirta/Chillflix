package view.customer;

import factory.subscription.FreeFactory;
import factory.subscription.PremiumFactory;
import factory.subscription.SubscriptionFactory;
import model.user.Customer;

import java.util.Scanner;

public class SubscriptionManagementView {
	private Customer customer;
	private Scanner scanner = new Scanner(System.in);

	public SubscriptionManagementView(Customer customer) {
		this.customer = customer;
	}

	public void displayMenu() {
		System.out.println("\n=== Subscription Management ===");
		System.out.println("Current Subscription: " + customer.getSubscription().getType());
		System.out.println("1. Upgrade to Premium Subscription");
		System.out.println("2. Cancel Subscription");
		System.out.println("3. Back to Menu");
		System.out.print(">> ");
		int choice = scanner.nextInt();

		SubscriptionFactory factory = null;
		switch (choice) {
		case 1:
			factory = new PremiumFactory();
			break;
		case 2:
			factory = new FreeFactory();
			break;
		case 3:
			System.out.println("Returning to previous menu...");
			return;
		default:
			System.out.println("Invalid choice.");
			return;
		}

		if (factory != null) {
			customer.setSubscription(factory.createSubscription());
			System.out.println("Subscription updated to: " + customer.getSubscription().getType());
		}
	}
}
