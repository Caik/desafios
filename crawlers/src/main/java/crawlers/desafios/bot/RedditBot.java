package crawlers.desafios.bot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import crawlers.desafios.entity.SubRedditScraper;

public class RedditBot extends TelegramLongPollingBot {

	public static final String AUTH_TOKEN = "477614167:AAFJueYz6BTzLga__E7Bj62hgHMeKC5k7DE";

	public static final String BOT_USERNAME = "IDWallCrawler_Bot";

	public static final String NADA_PRA_FAZER_COMMAND = "/NadaPraFazer";

	public static final String[] subRedditsSugestions = {"worldnews", "brazil", "cats", "movies", "videos", "AskReddit", "sports"};

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			System.out.println("Update recebido! Tratando.");
			String messageText = update.getMessage().getText();
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
			String text = getInvalidCommandMsg();

			if (messageText.startsWith(NADA_PRA_FAZER_COMMAND)) {
				List<String> subReddits = getSubReddits(messageText);

				if (subReddits.size() == 0) {
					text = getNoArgumentsMsg();
				} else {
					try {
						text = getSubRedditsInText(subReddits);
					} catch (IOException e) {
						text = getErrorMsg(messageText);
					}
				}
			}

			message.setText(text);

			try {
				execute(message);
				System.out.println("Resposta enviada.");
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	private String getSubRedditsInText(List<String> subReddits) throws IOException {
		String text = "";
		SubRedditScraper subRed = new SubRedditScraper();

		for (String subReddit : subReddits) {
			subRed.setUrl(subReddit);
			subRed.requestThreads();
			text += subRed.getThreadsInText();
		}

		return text;
	}

	List<String> getSubReddits(String messageText) {
		List<String> subReddits = new ArrayList<String>();

		messageText = messageText.replaceAll(NADA_PRA_FAZER_COMMAND, "").trim();

		if (messageText.isEmpty()) {
			return subReddits;
		}

		subReddits = Arrays.asList(messageText.replaceAll("(^;|;$)", "").split(";"));

		if (subReddits.size() == 0) {
			subReddits.add(messageText);
		}

		return subReddits;
	}

	@Override
	public String getBotToken() {
		return AUTH_TOKEN;
	}

	@Override
	public String getBotUsername() {
		return BOT_USERNAME;
	}

	public String getInvalidCommandMsg() {
		return "Desculpe, mas não entendi o seu comando!\nQue tal tentar: " + NADA_PRA_FAZER_COMMAND + " worldnews;cats";
	}

	public String getNoArgumentsMsg() {
		return "Sem ideia de algum subReddit?\nQue tal: " + NADA_PRA_FAZER_COMMAND + " " + RedditBot.subRedditsSugestions[new Random().nextInt(RedditBot.subRedditsSugestions.length)];
	}

	private String getErrorMsg(String messageText) {
		return "Desculpe, mas ocorreu algum erro ao procurar por: " + messageText;
	}
}
