package controller;

import java.util.List;

import database.UserDatabase;
import factory.user.AdminFactory;
import factory.user.CustomerFactory;
import model.user.User;

public class UserController {
	private UserDatabase userDatabase = UserDatabase.getInstance();

	private boolean isValidEmail(String email) {
		return email != null && email.endsWith("@gmail.com");
	}

	private boolean isValidPassword(String password) {
		return password != null && password.length() >= 6;
	}

	private boolean isValidName(String name) {
		return name != null && !name.trim().isEmpty();
	}

	private boolean isValidRole(String role) {
		return "Customer".equalsIgnoreCase(role) || "Admin".equalsIgnoreCase(role);
	}

	public User loginUser(String email, String password) {
		return userDatabase.getUserByEmailAndPassword(email, password);
	}

	public boolean register(String name, String email, String password, String role) {
		if (!isValidName(name)) {
			System.out.println("Invalid name. Name cannot be empty.");
			return false;
		}
		if (!isValidEmail(email)) {
			System.out.println("Invalid email format.");
			return false;
		}
		if (!isValidPassword(password)) {
			System.out.println("Password must be at least 6 characters long.");
			return false;
		}
		if (!isValidRole(role)) {
			System.out.println("Invalid role. Choose either 'Customer' or 'Admin'.");
			return false;
		}
		if (userDatabase.getUserByEmail(email) != null) {
			System.out.println("Email already exists.");
			return false;
		}

		int userId = userDatabase.getAllUsers().size() + 1;
		User newUser = null;

		if ("Customer".equalsIgnoreCase(role)) {
			CustomerFactory customerFactory = new CustomerFactory();
			newUser = customerFactory.createUser(userId, name, email, password);
		} else if ("Admin".equalsIgnoreCase(role)) {
			AdminFactory adminFactory = new AdminFactory();
			newUser = adminFactory.createUser(userId, name, email, password);
		}

		userDatabase.addUser(newUser);

		return true;
	}

	public List<User> getAllUsers() {
		return userDatabase.getAllUsers();
	}

	public User getUserById(int id) {
		return userDatabase.getUserById(id);
	}
	
	public User getUserByEmail(String email) {
		return userDatabase.getUserByEmail(email);
	}

	public boolean updateCustomer(int id, String name, String email, String password) {
		User user = userDatabase.getUserById(id);
		if (user != null && user instanceof model.user.Customer) {
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			return true;
		}
		return false;
	}

	public boolean deleteUser(int id) {
		User user = userDatabase.getUserById(id);
		if (user == null) {
			System.out.println("User with ID " + id + " not found");
			return false;
		}

		userDatabase.deleteUser(id);
		return true;
	}

}
