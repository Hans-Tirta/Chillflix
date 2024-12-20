package model.content;

public abstract class Content {
	private int id;
	private String title;
	private int year;
	private String age;
	private String type;
	private String genre;
	private double rating;
	private double totalRating;
	private int ratingCount;
	private String description;

	public Content(int id, String title, int year, String age, String type, String genre, String description) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.age = age;
		this.type = type;
		this.genre = genre;
		this.rating = 0.0; // Default rating
		this.totalRating = 0.0; // Default total rating
		this.ratingCount = 0;
		this.description = description;
	}

	public void addRating(double rating) {
		this.totalRating += rating;
		this.ratingCount++;
		this.rating = totalRating / ratingCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(double totalRating) {
		this.totalRating = totalRating;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return id + " | " + title + " | " + year + " | " + age + " | " + type + " | " + genre + " | " + rating + " | "
				+ description;
	}

}
