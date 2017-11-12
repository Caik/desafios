package crawlers.desafios.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SubRedditScraper {

	private final String protocol = "http://";

	private final String baseUrl = "www.reddit.com/r/";

	private String url;

	private int minScore = 5000;

	private List<RedditThread> threads = new ArrayList<RedditThread>();

	public String getProtocol() {
		return protocol;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMinScore() {
		return minScore;
	}

	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}

	public List<RedditThread> getThreads() {
		return threads;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void requestThreads() throws IOException {
		this.threads = new ArrayList<RedditThread>();

		Document document = Jsoup.connect(this.protocol + this.baseUrl + this.url).get();
		Elements elements = document.getElementsByClass("thing");

		for (Element element : elements) {
			int score = new Integer(element.attr("data-score"));

			if (score < this.minScore) {
				continue;
			}

			RedditThread thread = new RedditThread();
			thread.setScore(score);
			thread.setCommentsLinks(this.protocol + this.baseUrl + element.attr("data-permalink").replaceFirst("^/r/", ""));
			thread.setSelfLink(element.attr("data-url"));
			thread.setSubReddit(element.attr("data-subreddit"));

			Element titleElement = element.selectFirst("a.title");
			thread.setTitle(titleElement.text());

			this.threads.add(thread);
		}
	}

	public String getThreadsInText() {
		String text = "";

		if (this.threads.size() == 0) {
			text += "Nenhuma Thread a ser mostrada!\n";
			text += " - Subreddit: " + this.url + "\n";
			text += " - Score mínimo: " + this.minScore + "\n";
			text += "----------------------------------------\n";
			return text;
		}

		for (RedditThread thread : this.threads) {
			text += thread;
		}

		return text;
	}

}
