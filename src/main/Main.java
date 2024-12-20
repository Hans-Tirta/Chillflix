package main;

import java.util.Scanner;

import database.ContentDatabase;
import database.UserDatabase;
import view.LoginView;
import view.RegisterView;

public class Main {

	public Main() {
		UserDatabase.getInstance();
		ContentDatabase.getInstance();

		Scanner scanner = new Scanner(System.in);
		LoginView loginView = new LoginView();
		RegisterView registerView = new RegisterView();

		while (true) {
			System.out.println("   ___ _    _ _ _  __ _ _     ");
			System.out.println("  / __| |_ (_) | |/ _| (_)_ __");
			System.out.println(" | (__| ' \\| | | |  _| | \\ \\ /");
			System.out.println("  \\___|_||_|_|_|_|_| |_|_/_\\_\\");
			System.out.println("\n========== Main Menu ==========");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print(">> ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				loginView.handleLogin();
				break;
			case 2:
				registerView.displayRegister();
				break;
			case 3:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
