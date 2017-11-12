package crawlers.desafios.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SubReddit {

	private final String protocol = "http://";

	private final String baseURL = "www.reddit.com/r/";

	private String url;

	private int minScore;

	private List<Thread> threads = new ArrayList<Thread>();

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

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void requestThreads() throws IOException {
		Document document = Jsoup.connect(this.protocol + this.baseURL + this.url).get();
		Elements elements = document.getElementsByClass("thing");

		for (Element element : elements) {
			int score = new Integer(element.attr("data-score"));

			if (score < this.minScore) {
				continue;
			}

			Thread thread = new Thread();
			thread.setScore(score);
			thread.setCommentsLinks(this.protocol + this.baseURL + element.attr("data-permalink").replaceFirst("^/r/", ""));
			thread.setSelfLink(element.attr("data-url"));
			thread.setSubReddit(element.attr("data-subreddit"));

			Element titleElement = element.selectFirst("a.title");
			thread.setTitle(titleElement.text());

			this.threads.add(thread);
		}
	}

	public void showThreads() {
		if (this.threads.size() == 0) {
			System.out.println("Nenhuma Thread a ser mostrada! Subreddit: " + this.url + ", Score mínimo: " + this.minScore + "\n");
			return;
		}

		for (Thread thread : this.threads) {
			System.out.println(thread);
		}
	}
}
