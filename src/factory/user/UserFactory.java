package factory.user;

import model.user.User;

public abstract class UserFactory {

	public abstract User createUser(int id, String name, String email, String password);

}
