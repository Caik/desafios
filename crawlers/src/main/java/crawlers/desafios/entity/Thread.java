package crawlers.desafios.entity;

public class Thread {

	private String subReddit;

	private String title;

	private int score;

	private String selfLink;

	private String commentsLinks;

	public String getSubReddit() {
		return subReddit;
	}

	public void setSubReddit(String subReddit) {
		this.subReddit = subReddit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getSelfLink() {
		return selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	public String getCommentsLinks() {
		return commentsLinks;
	}

	public void setCommentsLinks(String commentsLinks) {
		this.commentsLinks = commentsLinks;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "Título: " + this.title + "\n";
		ret += " - SubReddit: " + this.subReddit + "\n";
		ret += " - Link: " + this.selfLink + "\n";
		ret += " - Score: " + this.score + "\n";
		ret += " - Comentários link: " + this.commentsLinks + "\n";

		return ret;
	}
}
