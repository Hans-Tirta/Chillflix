package model.user;

import factory.subscription.FreeFactory;
import model.Playlist;
import model.subscription.Subscription;

public class Customer extends User {
	private Playlist playlist;
	private Subscription subscription;

	public Customer(int id, String name, String email, String password) {
		super(id, name, email, password, "Customer");
		this.playlist = new Playlist();
		this.subscription = new FreeFactory().createSubscription();
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

}
