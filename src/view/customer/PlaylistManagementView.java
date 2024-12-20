package view.customer;

import controller.PlaylistController;
import database.ContentDatabase;
import model.user.Customer;
import model.Playlist;
import model.content.Content;

import java.util.Scanner;

public class PlaylistManagementView {

	private Scanner scanner = new Scanner(System.in);
	private PlaylistController playlistController = new PlaylistController();
	private Customer loggedInCustomer;

	public PlaylistManagementView(Customer loggedInCustomer) {
		this.loggedInCustomer = loggedInCustomer;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n=== Manage Playlist ===");
			System.out.println("1. View Playlist");
			System.out.println("2. Add Content to Playlist");
			System.out.println("3. Remove Content from Playlist");
			System.out.println("4. Clear Playlist");
			System.out.println("5. Back to Main Menu");
			System.out.print(">> ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				playlistController.viewPlaylist(loggedInCustomer);
				break;
			case 2:
				addContent();
				break;
			case 3:
				removeContent();
				break;
			case 4:
				playlistController.clearPlaylist(loggedInCustomer);
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	private void addContent() {
		ContentDatabase contentDatabase = ContentDatabase.getInstance();
		System.out.println("\n=== Available Content ===");
		for (Content content : contentDatabase.getAllContents()) {
			System.out.println(content.getId() + ". " + content.getTitle());
		}
		System.out.print("Enter content ID to add: ");
		int contentId = scanner.nextInt();

		Content content = contentDatabase.getContentById(contentId);
		if (content != null) {
			playlistController.addToPlaylist(loggedInCustomer, content);
		} else {
			System.out.println("Invalid content ID.");
		}
	}

	private void removeContent() {
		System.out.println("\n=== Playlist Content ===");
		Playlist playlist = loggedInCustomer.getPlaylist();
		for (Content content : playlist.getContents()) {
			System.out.println(content.getId() + ". " + content.getTitle());
		}
		System.out.print("Enter content ID to remove: ");
		int contentId = scanner.nextInt();

		ContentDatabase contentDatabase = ContentDatabase.getInstance();
		Content content = contentDatabase.getContentById(contentId);
		if (content != null) {
			playlistController.removeFromPlaylist(loggedInCustomer, content);
		} else {
			System.out.println("Invalid content ID.");
		}
	}
}
