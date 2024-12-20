package database;

import model.user.User;
import model.user.Customer;
import model.user.Admin;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
	private static UserDatabase instance;
	private List<User> users = new ArrayList<>();

	private UserDatabase() {
		// Sample data
		users.add(new Admin(1, "Admin", "admin@gmail.com", "123123"));
		users.add(new Customer(2, "Andi", "andi@gmail.com", "123123"));
		users.add(new Customer(3, "Budi", "budi@gmail.com", "123123"));
		users.add(new Customer(4, "Clara", "clara@gmail.com", "123123"));
		users.add(new Customer(5, "Dodi", "dodi@gmail.com", "123123"));
	}

	public static UserDatabase getInstance() {
		if (instance == null) {
			instance = new UserDatabase();
		}
		return instance;
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUserByEmail(String email) {
		for (User user : users) {
			if (user.getEmail().equals(email))
				return user;
		}
		return null;
	}

	public User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User getUserByEmailAndPassword(String email, String password) {
		return users.stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
				.findFirst().orElse(null);
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void deleteUser(int id) {
		users.removeIf(user -> user.getId() == id);
	}

}
