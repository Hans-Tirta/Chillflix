package observer;

import model.Notification;
import model.user.User;

public interface IObserver {
	void addUser(User user);

	void removeUser(User user);

	void notifyUsers(Notification notification);

	void notifyFreeUsers(Notification notification);

	void notifyPremiumUsers(Notification notification);

	void sendEmailNotification(User user, Notification notification);
}
