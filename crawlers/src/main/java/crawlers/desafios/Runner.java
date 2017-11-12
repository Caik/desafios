package crawlers.desafios;

import java.io.IOException;

import crawlers.desafios.entity.SubReddit;

public class Runner {

	public static void main(String[] args) {
		SubReddit reddit = new SubReddit();
		reddit.setUrl("worldnews");
		reddit.setMinScore(5000);

		try {
			reddit.requestThreads();
			reddit.showThreads();
		} catch (IOException e) {
			System.out.println("DEU ERRO");
		}
	}

}
