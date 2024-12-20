package factory.content;

import model.content.Content;
import model.content.Movie;

public class MovieFactory extends ContentFactory {

	@Override
	public Content createContent(int id, String title, int year, String age, String type, String genre,
			String description) {
		return new Movie(id, title, year, age, type, genre, description);
	}

}
