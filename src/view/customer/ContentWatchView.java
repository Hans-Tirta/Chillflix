package view.customer;

import controller.ContentController;
import model.content.Content;
import model.user.Customer;

import java.util.List;
import java.util.Scanner;

public class ContentWatchView {
	private Scanner scanner = new Scanner(System.in);
	private ContentController contentController = new ContentController();
	private Customer loggedInCustomer;

	public ContentWatchView(Customer loggedInCustomer) {
		this.loggedInCustomer = loggedInCustomer;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n========== Content Menu ==========");
			System.out.println("1. Watch Movies");
			System.out.println("2. Watch Shows");
			System.out.println("3. Exit");
			System.out.print(">> ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				displayMovies();
				break;
			case 2:
				displayShows();
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private void displayMovies() {
		List<Content> movies = contentController.getContentByType("Movie");
		if (movies.isEmpty()) {
			System.out.println("No movies available.");
			return;
		}

		System.out.println("\n=== Movies ===");
		System.out.println("==================================================================================");
		System.out.println("| No | Title             | Year | Age   | Genre      | Rating |");
		System.out.println("==================================================================================");
		for (int i = 0; i < movies.size(); i++) {
			Content movie = movies.get(i);
			System.out.printf("| %-2d | %-17s | %-4d | %-5s | %-10s | %-3.1f (%d) |\n", i + 1, movie.getTitle(),
					movie.getYear(), movie.getAge(), movie.getGenre(), movie.getRating(), movie.getRatingCount());
		}
		System.out.println("==================================================================================");

		System.out.print("Choose a movie to watch (0 to go back): ");
		int choice = scanner.nextInt();
		if (choice > 0 && choice <= movies.size()) {
			Content selectedMovie = movies.get(choice - 1);
			checkSubscriptionAndWatch(selectedMovie);
		} else if (choice != 0) {
			System.out.println("Invalid choice. Returning to menu...");
		}
	}

	private void displayShows() {
		List<Content> shows = contentController.getContentByType("Show");
		if (shows.isEmpty()) {
			System.out.println("No shows available.");
			return;
		}

		System.out.println("\n=== Shows ===");
		System.out.println("==================================================================================");
		System.out.println("| No | Title             | Year | Age   | Genre      | Rating |");
		System.out.println("==================================================================================");
		for (int i = 0; i < shows.size(); i++) {
			Content show = shows.get(i);
			System.out.printf("| %-2d | %-17s | %-4d | %-5s | %-10s | %-3.1f (%d) |\n", i + 1, show.getTitle(),
					show.getYear(), show.getAge(), show.getGenre(), show.getRating(), show.getRatingCount());
		}
		System.out.println("==================================================================================");

		System.out.print("Choose a show to watch (0 to go back): ");
		int choice = scanner.nextInt();
		if (choice > 0 && choice <= shows.size()) {
			Content selectedShow = shows.get(choice - 1);
			checkSubscriptionAndWatch(selectedShow);
		} else if (choice != 0) {
			System.out.println("Invalid choice. Returning to menu...");
		}
	}

	private void checkSubscriptionAndWatch(Content content) {
		String subscriptionType = loggedInCustomer.getSubscription().getType();
		if ("Free".equalsIgnoreCase(subscriptionType)) {
			System.out.println("\nYou are on a Free subscription. Please watch this ad first:");
			watchAd();
		}
		watchContent(content);
	}

	private void watchAd() {
		try {
			System.out.println("Ad.");
			Thread.sleep(1000);
			System.out.println("Ad..");
			Thread.sleep(1000);
			System.out.println("Ad..");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("An error occurred while watching the ad.");
		}
	}

	private void watchContent(Content content) {
		System.out.println("\nNow watching: " + content.getTitle());
		System.out.println("Description: " + content.getDescription());

		try {
			System.out.println("\nWatching.");
			Thread.sleep(1000);
			System.out.println("Watching..");
			Thread.sleep(1000);
			System.out.println("Watching...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("An error occurred while waiting.");
		}

		System.out.println("\nWould you like to give a rating?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.print(">> ");
		int choice = scanner.nextInt();

		if (choice == 1) {
			giveRating(content);
		}
	}

	private void giveRating(Content content) {
		System.out.print("Enter your rating (1.0 to 10.0): ");
		double rating = scanner.nextDouble();
		if (rating < 1.0 || rating > 10.0) {
			System.out.println("Invalid rating. Please enter a value between 1.0 and 10.0.");
			return;
		}

		contentController.rateContent(content.getId(), rating);
		System.out.println("Thank you for your rating!");
	}
}
