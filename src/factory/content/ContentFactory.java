package factory.content;

import model.content.Content;

public abstract class ContentFactory {

	public abstract Content createContent(int id, String title, int year, String age, String type, String genre,
			String description);

}
