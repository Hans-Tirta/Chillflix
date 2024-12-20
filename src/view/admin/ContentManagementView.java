package view.admin;

import controller.ContentController;
import model.content.Content;

import java.util.Scanner;

public class ContentManagementView {
	private ContentController contentController = new ContentController();
	private Scanner scanner = new Scanner(System.in);

	public void displayMenu() {
		while (true) {
			System.out.println("\n=== Manage Contents ===");
			System.out.println("1. View All Contents");
			System.out.println("2. Add Content");
			System.out.println("3. Update Content");
			System.out.println("4. Delete Content");
			System.out.println("5. Back");
			System.out.print(">> ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				viewAllContent();
				break;
			case 2:
				viewAllContent();
				addContent();
				break;
			case 3:
				viewAllContent();
				updateContent();
				break;
			case 4:
				viewAllContent();
				deleteContent();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}

	private void viewAllContent() {
		System.out.println("\n=== Content List ===");
		System.out.println(
				"============================================================================================================");
		System.out.println(
				"| ID   | Title             | Year | Age   | Type    | Genre      | Rating | Description                    |");
		System.out.println(
				"============================================================================================================");
		for (Content content : contentController.getAllContents()) {
			System.out.printf("| %-4d | %-17s | %-4d | %-5s | %-7s | %-10s | %-6.1f | %-30s |\n", content.getId(),
					content.getTitle(), content.getYear(), content.getAge(), content.getType(), content.getGenre(),
					content.getRating(), content.getDescription());
		}
		System.out.println(
				"============================================================================================================");
	}

	private void addContent() {
		System.out.println("\n=== Add Content ===");
		System.out.print("Enter Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter Year: ");
		int year = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Age Restriction: ");
		String age = scanner.nextLine();
		System.out.print("Enter Type (Movie/Show): ");
		String type = scanner.nextLine();
		System.out.print("Enter Genre: ");
		String genre = scanner.nextLine();
		System.out.print("Enter Description: ");
		String description = scanner.nextLine();

		contentController.addContent(title, year, age, type, genre, description);
		System.out.println("Content added successfully!");
	}

	private void updateContent() {
		System.out.println("\n=== Update Content ===");
		System.out.print("Enter ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter New Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter New Year: ");
		int year = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter New Age Restriction: ");
		String age = scanner.nextLine();
		System.out.print("Enter New Type (Movie/Show): ");
		String type = scanner.nextLine();
		System.out.print("Enter New Genre: ");
		String genre = scanner.nextLine();
		System.out.print("Enter New Description: ");
		String description = scanner.nextLine();

		contentController.updateContent(id, title, year, age, type, genre, description);
		System.out.println("Content updated successfully!");
	}

	private void deleteContent() {
		System.out.println("\n=== Delete Content ===");
		System.out.print("Enter ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		if (contentController.deleteContent(id)) {
			System.out.println("Content deleted successfully!");
		} else {
			System.out.println("Content not found!");
		}
	}
}
