package factory.user;

import model.user.Admin;
import model.user.User;

public class AdminFactory extends UserFactory {
	@Override
	public User createUser(int id, String name, String email, String password) {
		return new Admin(id, name, email, password);
	}
}
