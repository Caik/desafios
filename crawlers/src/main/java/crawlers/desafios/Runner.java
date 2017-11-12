package crawlers.desafios;

import java.io.IOException;

import org.apache.commons.validator.routines.IntegerValidator;

import crawlers.desafios.entity.SubRedditScraper;

public class Runner {

	public static void main(String[] args) {
		if (!validateArgs(args)) {
			System.out.println("Usage: java -jar crawlers.desafios-deploy.jar subReddit1[;suReddit2;subReddit3...] [minScore]");
			System.out.println(" - subReddit: String. Lista com um ou mais subReddits a serem consultados.");
			System.out.println(" - minScore: Inteiro. Pontuação mímina da Thread a ser retornada (opcional: por padrão o valor é 5000).");
			System.exit(1);
		}

		SubRedditScraper reddit = new SubRedditScraper();
		reddit.setUrl(args[0]);

		if (args.length > 1) {
			IntegerValidator intValidator = IntegerValidator.getInstance();
			reddit.setMinScore(intValidator.validate(args[1]));
		}

		try {
			reddit.requestThreads();
			System.out.println(reddit.getThreadsInText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static boolean validateArgs(String[] args) {
		if (args == null || args.length < 1) {
			return false;
		}

		if (args[0].matches(".*[^a-zA-Z0-9;].*")) {
			return false;
		}

		if (args.length > 1) {
			IntegerValidator intValidator = IntegerValidator.getInstance();

			if (!intValidator.isValid(args[1])) {
				return false;
			}
		}

		return true;
	}

}
