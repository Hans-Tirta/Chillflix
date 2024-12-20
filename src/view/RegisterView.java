package view;

import controller.UserController;

import java.util.Scanner;

public class RegisterView {

	private Scanner scanner = new Scanner(System.in);
	private UserController controller = new UserController();

	public void displayRegister() {
		System.out.println("\n=== Register ===");
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		System.out.print("Role (Customer/Admin): ");
		String role = scanner.nextLine();

		if (controller.register(name, email, password, role)) {
			System.out.println("Registration successful");
		} else {
			System.out.println("Registration failed");
		}
	}
}
