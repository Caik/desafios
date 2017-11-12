package crawlers.desafios;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import crawlers.desafios.bot.RedditBot;

public class BotRunner {

	public static void main(String[] args) {
		System.out.println("Iniciando BOT.");
		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(new RedditBot());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}

}
