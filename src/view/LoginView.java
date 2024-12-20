package view;

import controller.UserController;
import model.user.User;

import java.util.Scanner;

public class LoginView {

	private Scanner scanner = new Scanner(System.in);
	private UserController userController = new UserController();

	public void handleLogin() {
		User user = displayLogin();
		if (user != null) {
			navigateToRoleMenu(user);
		}
	}

	public User displayLogin() {
		System.out.println("\n=== Login ===");
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();

		User user = userController.loginUser(email, password);

		if (user == null) {
			System.out.println("Invalid email or password!");
		} else {
			System.out.println("Login successful as " + user.getRole());
		}

		return user;
	}

	private void navigateToRoleMenu(User user) {
		if ("admin".equalsIgnoreCase(user.getRole())) {
			new view.admin.AdminMenuView(user).displayMenu();
		} else if ("customer".equalsIgnoreCase(user.getRole())) {
			new view.customer.CustomerMenuView(user).displayMenu();
		}
	}
}
