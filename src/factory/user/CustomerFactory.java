package factory.user;

import model.user.Customer;
import model.user.User;

public class CustomerFactory extends UserFactory {
	@Override
	public User createUser(int id, String name, String email, String password) {
		return new Customer(id, name, email, password);
	}
}
