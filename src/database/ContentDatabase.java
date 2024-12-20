package database;

import model.content.Content;
import model.content.Movie;
import model.content.Show;

import java.util.ArrayList;
import java.util.List;

public class ContentDatabase {
	private static ContentDatabase instance;
	private List<Content> contents = new ArrayList<>();

	private ContentDatabase() {
		// Sample Movies
		contents.add(new Movie(1, "Inception", 2010, "13+", "Movie", "Sci-Fi", "A mind-bending thriller"));
		contents.add(new Movie(2, "The Dark Knight", 2008, "13+", "Movie", "Action", "Batman and Joker"));
		contents.add(new Movie(3, "Interstellar", 2014, "13+", "Movie", "Sci-Fi", "Exploring space"));
		contents.add(new Movie(4, "Parasite", 2019, "18+", "Movie", "Thriller", "Commentary on class divide"));
		contents.add(new Movie(5, "Avengers: Endgame", 2019, "13+", "Movie", "Action", "The epic Avengers"));

		// Sample Shows
		contents.add(new Show(6, "Breaking Bad", 2008, "18+", "Show", "Drama", "A chemistry teacher"));
		contents.add(new Show(7, "Stranger Things", 2016, "13+", "Show", "Sci-Fi", "Mysteries in strangers"));
		contents.add(new Show(8, "The Crown", 2016, "18+", "Show", "Drama", "The British monarchy"));
		contents.add(new Show(9, "The Mandalorian", 2019, "13+", "Show", "Sci-Fi", "A hunter's adventures"));
		contents.add(new Show(10, "Friends", 1994, "13+", "Show", "Comedy", "Six friends in New York"));
	}

	public static ContentDatabase getInstance() {
		if (instance == null) {
			instance = new ContentDatabase();
		}
		return instance;
	}

	public List<Content> getAllContents() {
		return contents;
	}

	public Content getContentById(int id) {
		for (Content content : contents) {
			if (content.getId() == id)
				return content;
		}
		return null;
	}

	public void addContent(Content content) {
		contents.add(content);
	}

	public void updateContent(Content content) {
		Content existingContent = getContentById(content.getId());
		if (existingContent != null) {
			existingContent.setTitle(content.getTitle());
			existingContent.setYear(content.getYear());
			existingContent.setAge(content.getAge());
			existingContent.setType(content.getType());
			existingContent.setGenre(content.getGenre());
			existingContent.setRating(content.getRating());
			existingContent.setDescription(content.getDescription());
		}
	}

	public void deleteContent(int id) {
		contents.removeIf(content -> content.getId() == id);
	}

}
