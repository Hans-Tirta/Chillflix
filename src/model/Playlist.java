package model;

import java.util.ArrayList;
import java.util.List;
import model.content.Content;

public class Playlist {
	private List<Content> contents;

	public Playlist() {
		this.contents = new ArrayList<>();
	}

	public List<Content> getContents() {
		return contents;
	}

	public void addContent(Content content) {
		contents.add(content);
	}

	public void removeContent(Content content) {
		contents.remove(content);
	}

	public void clearContents() {
		contents.clear();
	}

	public boolean isEmpty() {
		return contents.isEmpty();
	}
}
