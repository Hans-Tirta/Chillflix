package controller;

import model.user.Customer;
import model.Playlist;
import model.content.Content;

public class PlaylistController {

	public void viewPlaylist(Customer customer) {
		Playlist playlist = customer.getPlaylist();
		if (playlist.isEmpty()) {
			System.out.println("Your playlist is empty.");
		} else {
			System.out.println("\n=== Playlist ===");
			for (Content content : playlist.getContents()) {
				System.out.println("- " + content.getTitle() + " (" + content.getYear() + ")");
			}
		}
	}

	public void addToPlaylist(Customer customer, Content content) {
		customer.getPlaylist().addContent(content);
		System.out.println("Added " + content.getTitle() + " to your playlist.");
	}

	public void removeFromPlaylist(Customer customer, Content content) {
		Playlist playlist = customer.getPlaylist();
		if (playlist.getContents().contains(content)) {
			playlist.removeContent(content);
			System.out.println("Removed " + content.getTitle() + " from your playlist.");
		} else {
			System.out.println("Content not found in your playlist.");
		}
	}

	public void clearPlaylist(Customer customer) {
		customer.getPlaylist().clearContents();
		System.out.println("Playlist cleared.");
	}
}
