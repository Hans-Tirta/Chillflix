package controller;

import database.ContentDatabase;
import factory.content.MovieFactory;
import factory.content.ShowFactory;
import model.content.Content;

import java.util.List;
import java.util.stream.Collectors;

public class ContentController {
	private ContentDatabase contentDatabase = ContentDatabase.getInstance();

	public List<Content> getAllContents() {
		return contentDatabase.getAllContents();
	}

	public Content getContentById(int id) {
		return contentDatabase.getContentById(id);
	}

	public List<Content> getContentByType(String type) {
		return contentDatabase.getAllContents().stream().filter(content -> type.equalsIgnoreCase(content.getType()))
				.collect(Collectors.toList());
	}

	public void addContent(String title, int year, String age, String type, String genre, String description) {
		int id = contentDatabase.getAllContents().size() + 1;
		Content content = null;

		if ("Movie".equalsIgnoreCase(type)) {
			MovieFactory movieFactory = new MovieFactory();
			content = movieFactory.createContent(id, title, year, age, type, genre, description);
		} else if ("Show".equalsIgnoreCase(type)) {
			ShowFactory showFactory = new ShowFactory();
			content = showFactory.createContent(id, title, year, age, type, genre, description);
		}

		contentDatabase.addContent(content);
	}

	public void updateContent(int id, String title, int year, String age, String type, String genre,
			String description) {
		Content content = null;

		if ("Movie".equalsIgnoreCase(type)) {
			MovieFactory movieFactory = new MovieFactory();
			content = movieFactory.createContent(id, title, year, age, type, genre, description);
		} else if ("Show".equalsIgnoreCase(type)) {
			ShowFactory showFactory = new ShowFactory();
			content = showFactory.createContent(id, title, year, age, type, genre, description);
		} 

		contentDatabase.updateContent(content);
	}

	public boolean deleteContent(int id) {
		Content content = contentDatabase.getContentById(id);
		if (content == null) {
			System.out.println("Content with ID " + id + " not found");
			return false;
		}

		contentDatabase.deleteContent(id);
		return true;
	}

	public void rateContent(int contentId, double rating) {
		Content content = contentDatabase.getContentById(contentId);
		if (content == null) {
			System.out.println("Content not found!");
			return;
		}
		content.addRating(rating);
		System.out.println("Rating updated successfully for " + content.getTitle());
	}

}
